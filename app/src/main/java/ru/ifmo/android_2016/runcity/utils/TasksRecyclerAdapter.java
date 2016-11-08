package ru.ifmo.android_2016.runcity.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.ifmo.android_2016.runcity.R;
import ru.ifmo.android_2016.runcity.model.Task;

/**
 * Created by -- on 08.11.2016.
 */

public class TasksRecyclerAdapter extends RecyclerView.Adapter<TasksRecyclerAdapter.MovieViewHolder> {
    private final Context context;
    private final LayoutInflater layoutInflater;

    @NonNull
    private ArrayList<Task> tasks = new ArrayList<>();

    public TasksRecyclerAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setTasks(@NonNull ArrayList<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MovieViewHolder.newInstance(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final Task task = tasks.get(position);
        holder.taskPoint.setText(task.taskPoint.toString());
        holder.taskDescription.setText(task.taskDescription);
        holder.taskName.setText(task.taskName);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        final TextView taskName;
        final TextView taskDescription;
        final TextView taskPoint;

        private MovieViewHolder(View itemView) {
            super(itemView);
            taskName = (TextView) itemView.findViewById(R.id.task_name);
            taskDescription = (TextView) itemView.findViewById(R.id.task_description);
            taskPoint = (TextView) itemView.findViewById(R.id.task_point);
        }

        static MovieViewHolder newInstance(LayoutInflater layoutInflater, ViewGroup parent) {
            final View view = layoutInflater.inflate(R.layout.item_task, parent, false);
            return new MovieViewHolder(view);
        }
    }
}
