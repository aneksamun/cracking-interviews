# Image Storage   
Designed as solution to store each image efficiently so that it is not stored more than once.   
An example:  

    Insert <"Sunshine hotels", imageA>   
    Insert <"Stormy hotels", imageA>   
    Insert <"Beachfront Hotels", imageB>    

The store should have size 2 and contain imageA("Sunshine hotels", "Stormy hotels") and imageB("Beachfront Hotels").   

## Use case
```
$ java -jar storage-1.0.jar
Welcome to storage!

1 - add file
2 - get file
3 - get size
q - to quit

Enter option: 1
Enter image ID: 123
Enter image name including path: /home/sergey/Pictures/images.jpeg
Image stored successfully...

Enter option: 2
Enter image ID: 123
Enter path to store image: /home/sergey/Pictures/
Image retrieved successfully...

Enter option: q
```
## Build instructions

To build a project run
```
./mvnw clean install
```
It will create an executable jar file. 
