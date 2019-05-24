package io.simpolor.testing.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class DemoEvent {

    String name;

    int age;

    DemoState state;
}
