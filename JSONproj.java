import org.json.simple.JSONObject;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;
public class JSONproj
{

public static void main(String[] args) 
{
Map<String,JSONObject> obj = new HashMap<String,JSONObject>(); 
JSONObject json = new JSONObject();
Scanner inp = new Scanner(System.in); 
while(true) 
{
System.out.println("Enter the choice");
System.out.println("1.Create 2.Read 3.Delete");
int choice=inp.nextInt();
switch(choice) 
{
case 1:
while(true)
{
System.out.println("Enter the key");
String keyname=inp.nextLine();
if(obj.containsKey(keyname)) 
{
System.out.println("Key exists.");
break;
}	
while(true)
{
Map<String,String> v=new HashMap<String,String>();
while(true)
{
System.out.println("Enter the key of JSON object:\n");
String str1 = inp.nextLine();
System.out.println("Enter the value of JSON object:\n");
String str2 = inp.nextLine();
v.put(str1,str2);
System.out.println("Continue with values?\n");
System.out.println("select 1.Yes 2.No");
int choice2=inp.nextInt();
if(choice2==1)
continue;
else if(choice2==2)
break;
}
JSONObject obj1=new JSONObject(v);
obj.put(keyname,obj1);
json.putAll(obj);
System.out.println("Continue with value?");
System.out.println("Select 1.Yes 2.No");
int choice3=inp.nextInt();
if(choice3==1)
continue;
else
break;
}
System.out.println("Continue with new key?");
System.out.println("1.Yes 2.No");
int choice4=inp.nextInt();
if(choice4==1)
continue;
else
break;
}
try (FileWriter file = new FileWriter("C://Users/Desktop/JSONFile.json"))
{
file.write(json.toJSONString());
file.flush();
}
catch(IOException e)
{
e.printStackTrace();
}
break;
case 2:
System.out.print("Enter the key to be read:");
String rkey = inp.nextLine();
if(json.containsKey(rkey)) {
Set<String> rvalue=json.keySet();
System.out.println(rvalue);
}
else
System.out.println("key is not available");
break;
case 3:
System.out.print("Enter the key");
String dkey=inp.nextLine();
if(json.containsKey(dkey)) 
{
json.remove(dkey);
System.out.println("successfully deleted");
}
else
System.out.println("key is not available");
break;
}
}
}
}