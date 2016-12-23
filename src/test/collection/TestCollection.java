package test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;
 
public class TestCollection {
   
  public static void print(Collection<? extends Object> c){
    Iterator<? extends Object> it = c.iterator();
    while (it.hasNext()) {
      Object object = (Object) it.next();
      System.out.println(object);
    }
  }
   
  @Test
  public void demo1(){
    Set<String> set = new HashSet<String>();
    set.add("AAA");
    set.add("BBB");
    set.add("CCC");
    print(set);
     
    //Set的第一种遍历方式:利用Iterator
    Iterator<String> it1 = set.iterator();

    while (it1.hasNext()){
      System.out.println("set one"+it1.next());
    }

    //Set的第一种遍历方式:利用foreach
    for (String sss : set) {
      System.out.println("set two"+sss);
    }
     
    List<String> list = new ArrayList<String>();
    list.add("DDDDD");
    list.add("EEEEE");
    list.add("FFFFF");
    print(list);
     
    //List的第一种遍历方式:因为list有顺序，利用size()和get()方法获取
    for (int i = 0; i < list.size(); i++) {
      System.out.println("list one "+list.get(i));
    }
    //List的第二种遍历方式：利用Iterator
    Iterator<String> it = list.iterator();
    while (it.hasNext()) {
      System.out.println("list two "+it.next());
    }
    //List的第三种遍历方式:利用foreach
    for (String s2 : list) {
      System.out.println("list three "+s2);
    }
     
    Map<String,String> map = new TreeMap<String, String>();
    map.put("Jerry", "10000");
    map.put("shellway", "20000");
    map.put("Kizi", "30000");
    print(map.entrySet());
    //Map的第一种遍历方式：先获得key,再获得值value
    Set<String> sett = map.keySet();
    for (String s : sett) {
      System.out.println("Map one "+s+":"+map.get(s));
    }
    //Map的第二种遍历方式：获得键值对
    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println("Map two "+entry.getKey()+" : "+entry.getValue());
    }
  }
}

