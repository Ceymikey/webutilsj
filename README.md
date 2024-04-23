# webutilsj
(web utilities java)

### Structure
Basic structure can be found below
```java
package org.example;

import java.io.IOException;

public class Cool {
    public static void main(String[] args) throws IOException {
        Connector.connect("website without http");
    }
}
```
Filled in example:
```java
package dev.ceymikey;

import java.io.IOException;

public class Cool {
    public static void main(String[] args) throws IOException {
        Connector.connect("gradle.org"); // No http protocols as you can see just the link
    }
}
```

### Results
Return values could be
```bash
Connection to hostname established // Green light
Everything else shows the target is dead
```

#### ⭐This
