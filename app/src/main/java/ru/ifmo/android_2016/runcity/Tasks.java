package ru.ifmo.android_2016.runcity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ru.ifmo.android_2016.runcity.model.Task;
import ru.ifmo.android_2016.runcity.utils.RecyclerDividersDecorator;
import ru.ifmo.android_2016.runcity.utils.TasksRecyclerAdapter;

public class Tasks extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button buttonSubmit;

    private TasksRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        buttonSubmit = (Button) findViewById(R.id.submit_tasks_button);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(
                new RecyclerDividersDecorator(getResources().getColor(R.color.gray_a)));

        // TODO
        // get list of tasks form BD

        final ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("task 1", "Very inportant task.ololololololol", 5));
        tasks.add(new Task("task 2", "Very inportant task 2.ololololololol", 10));
        tasks.add(new Task("task 3", "I just need a lot of text. I just need a lot of text." +
                " I just need a lot of text. I just need a lot of text. " +
                "I just need a lot of text. I just need a lot of text. I just need a lot of text. ", 3));
        tasks.add(new Task("task 4.Long Name", "task 4 description", 5));
        tasks.add(new Task("task 5", "and so on ....................", 5));
        displayNonEmptyData(tasks);
    }

    private void displayNonEmptyData(ArrayList<Task> tasks) {
        if (adapter == null) {
            adapter = new TasksRecyclerAdapter(this);
            recyclerView.setAdapter(adapter);
        }
        adapter.setTasks(tasks);
        recyclerView.setVisibility(View.VISIBLE);
    }
}
