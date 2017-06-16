package org.rebaze.gradle.testkit;

import org.gradle.api.Project;

public class SimpleExtension {
    final Project project;

    public SimpleExtension(Project project) {
        this.project = project;
    }
}
