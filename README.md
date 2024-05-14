## ColorLib - A Color API for Minecraft Spigot Messages

How to include the API with Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.Asintotoo</groupId>
        <artifactId>ColorLib</artifactId>
        <version>1.0.0</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

**Note**: ColorLib uses external Libraries that requires Shading in order to be used in your Minecraft Plugin, plese include the following in your *pom.yml*
```xml
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.1.0</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

# Usage
The Main Java method to process a String is *ColorLib.setColors("your message here");*

To add a *Gradient* use the <GRADIENT> tag:
```java
ColorLib.setColors("<GRADIENT:FF0000>This is a Gradient Text</GRADIENT:00FF00>");
```
![image](https://github.com/Asintotoo/ColorLib/assets/166311378/25021f09-8f48-4354-8494-0d4fbbc1917a)

To add a *Rainbow* text use the <RAINBOW> tag:
```java
ColorLib.setColors("<RAINBOW:1>This is a Rainbow Text</RAINBOW>");
```
![image](https://github.com/Asintotoo/ColorLib/assets/166311378/53d4c569-b6bf-4e55-8dc8-b41360341852)
The number after RAINBOW represents the saturation
```java
ColorLib.setColors("<RAINBOW:50>This is a Rainbow Text</RAINBOW>");
```
![image](https://github.com/Asintotoo/ColorLib/assets/166311378/776687d8-4b23-40d5-9b21-b8fd80ccb98d)

To set a simple solid color use the <SOLID> tag:
```java
ColorLib.setColors("<SOLID:aabbcc>This is a Solid Text");
```
![image](https://github.com/Asintotoo/ColorLib/assets/166311378/0bead61c-1f73-43f5-b519-ee371aba98d1)

**Note:** If your server is running a version before 1.16 the resulting color will be the nearest supported one (This also applies to gradient)

Normal Chat Color Codes works too:
```java
ColorLib.setColors("&5This is a Simple Text");
```
![image](https://github.com/Asintotoo/ColorLib/assets/166311378/4a56bf6e-9fb8-4b2d-a19f-4200303060af)


# Advanced Usage
The API comes with some additional method that you may want to use:

Get a processed text with the addition of inserting all PlaceholderAPI's placeholders refering to a given player:
```java
ColorLib.setColorsAndPlaceholders(Bukkit.getPlayer("Maggiollo"), "<GRADIENT:FF0000>Ciao %player_name%</GRADIENT:0000FF>");
```
![image](https://github.com/Asintotoo/ColorLib/assets/166311378/0abd3564-92ef-45ee-afdb-68261ac17547)

Get a processed text given a YamlConfiguration path:
```java
ColorLib.getColoredStringFromConfig((YamlConfiguration) plugin.getConfig(), "messages.example");
```
this will format the following text:
```yml
messages:
  example: "<SOLID:00aaff>This is an Example"
```

Get a processed text given a YamlConfiguration path and insert all PlaceholderAPI's placeholders refering to a given player:
```java
ColorLib.getColoredStringFromConfigWithPlaceholders((YamlConfiguration) plugin.getConfig(), Bukkit.getPlayer("Maggiollo"), "messages.example-papi");
```
this will format the following text replacing %player_name% with "Maggiollo":
```yml
messages:
  example-papi: "<SOLID:00aa55>Hello %player_name%"
```


