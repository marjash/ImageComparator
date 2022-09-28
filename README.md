## About

This project finds the difference between 2 images of the same size and draws a red rectangle around the distinct pixels.

## Usage

```java
File fileA = new File("src/main/resources/test1.jpg");
File fileB = new File("src/main/resources/test2.jpg");
GetImageWithHighlight image = new GetImageWithHighlight();
image.getImage(fileA, fileB);
```

## Demo

These 3 pictures show how it works:

### First image
![](https://github.com/marjash/ImageComparator/blob/main/src/main/resources/test1.jpg?raw=true)

### Second image with difference pixels
![](https://github.com/marjash/ImageComparator/blob/main/src/main/resources/test2.jpg?raw=true)

### Result
![](https://github.com/marjash/ImageComparator/blob/main/src/main/img.jpg?raw=true)
