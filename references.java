//----------------------------------    This program is not designed to run        -----------------------------------
//----------------------------------    It is designed to show the usage of many different methods      -----------------------------------
//----------------------------------    and nuiances of Java  and Android Studio   -----------------------------------





//                                  Packages
// Organized set of related classes and interfaces.
// Access packages using an import
// Helps to organize classes and interfaces to improve maintainability.

//                                  Interfaces
// Interfaces are sets of fields and abstract methods that allow implementing abstraction.
// Can be extended using another interface, package or class. 
// Creates abstraction

//                                  Classes
// A class contains attributes for objects to be created
// Can have private and public attributes as well as methods in order to act on those classes.
// Can inherit qualities from both interfaces and packages.

//                                  

// -----------------------Importing packages, interfaces and classes---------------------
import string;

import io.realm.RealmObject;        // Realm objects are database objects.

// Primary key is used to identify the realmobject. This is unique
// Annotations are used to include the necessary attributes from Realm
import io.realm.annotations.PrimaryKey;

// Realm attribute that tells the creation of this object that it is necessary
// Best to throw an error if this information is not taken.
import io.realm.annotations.Required;


// Creation of a class


// public abstract class
// Can use /\/\/\ if
// 1. We want to share code among several closely related classes. (Could use inheritence for this).
// 2. We expect that classes that extend this class have many common methods or fields or require access modifies other that private. 
// 3. We want to declare non-static or non-final fields. We can then define methods that can access and modify the state of the object with which they belong.


// Declaration of this class is under the impression that it will be a realm object (Database connection with a primary key in the form of a name).


/*         ---------------------------------------------- Usage of public, private and protected -----------------------------

                                         default         |       private         |       protected       |       public  
         Same Class                        YES           |         YES           |          YES          |        YES
         Same Package Subclass             YES           |          NO           |          YES          |        YES
         Same Package Non-Subclass         YES           |          NO           |          YES          |        YES
         Different Package Subclass        NO            |          NO           |          YES          |        YES
         Different Package Non-Subclass    NO            |          NO           |          NO           |        YES  
*/
public class User  extends RealmObject{

    @Required
    @PrimaryKey
    private String __id; // Declared this way because of the use of "id" used by some other class  ??? check on this.
    @Required
    private String userName;

    // Use static fields when we want to share values accross all objects of the same class. Kinda like a public but used internally
    private static int count;

    
    



    //Instantiate 
    public String get_id() { return _id; }

    public void set_id(String _id) { this._id = _id; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }
}





//----------------  Parent Classes and SubClasses  ---------------------
/*
 Parent classes and subclasses with overrides of parent method. 

 @Override method is better than using standard override because @Override will throw error if it is called in error (wrong name or wrong calls)
     Else it will create a new function and run it.

 @Override also improves readability.
 Especially useful if we have a lot of classes (we do)


 Use "implements" in order to use functions from an interface.
 Can also be used to use built in functions like listeners.
                 Super useful for interfaces. 
*/


class ParentClass{
    public void displayMethod(String message){
        System.out.println(message);

    }
}

class SubClass extends ParentClass{
    @Override
    public void displayMethod(String message){
        System.out.println("Message is: " + message);
    }

    public static void main(String[] args) {
        SubClass newObject = new SubClass();
        ParentClass object2 = new ParentClass();
        newObject.displayMethod("Hello World"); // Prints "Message is: Hello World"
        object2.displayMethod("Hello World");   // Prints "Hello World"
    }

}



// -------------------      Android Specific    ----------------
// For a method like onDestroy whose parent is AppCompatActivity
//      we can see examples like this

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onDestroy(){
        super.onDestroy();          // This will include all of the functionality of the parent function which would be the onDestroy() method from AppCompatActivity
                                    // AppCompatActivity{} is a class within Android Studio
    }
}













