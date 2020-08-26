package io.simpolor.test.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class DemoEvent {

    String name;

    int age;

    DemoState state;
}
