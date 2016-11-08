package ru.ifmo.android_2016.runcity.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by -- on 08.11.2016.
 */

public class Task {
    public final @NonNull String taskName;
    public final @NonNull String taskDescription;
    public final @NonNull Integer taskPoint;

    public Task(@NonNull String taskName, @NonNull String taskDescription, @NonNull Integer taskPoint) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskPoint = taskPoint;
    }
}
