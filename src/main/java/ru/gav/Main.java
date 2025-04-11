package ru.gav;

import ru.gav.model.CustomStringBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        customStringBuilder.append("Hello");
        System.out.println(customStringBuilder);
        customStringBuilder.append(", World!");
        System.out.println(customStringBuilder);
        customStringBuilder.undo();
        System.out.println(customStringBuilder);
    }
}
