package MarcellaJmartKD;

import java.util.*;
import java.util.Iterator;

public class Algorithm {
 private Algorithm()
 {
  
 }
 
 public static <T> List<T> collect(T [] array, T value)
    {
     List<T> list = new ArrayList<T>();
     for(T arr : array)
     {
      if(arr.equals(value))
      {
       list.add(arr);
      }
      else
      {
       continue;
      }
     }
     return list;
    }
 
 public static <T> List<T> collect(Iterable<T> iterable, T value)
    {
     return null;
    }
 
 public static <T> List<T> collect(Iterator<T> iterator, T value)
    {
  return null;
    }
 
 public static <T> List<T> collect(T [] array, Predicate<T> pred)
    {
     return null;
    }
 
 public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
    {
     return null;
    }
 
 public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred)
    {
     return null;
    }
 
 public static <T> int c(T [] array, T value)
 {
  int c = 0;
  
  for(T arrayValue : array)
  {
   if(arrayValue.equals(value))
   {
    c++;
   }
  }
  return c;
 }
 
 public static <T> int c(Iterable<T> iterable, T value)
 {
  int c = 0;
  
  for(T t : iterable)
  {
            if(t.equals(value))
            {
                c++;
            }
        }
        return c;
 }
 
 public static <T> int c(Iterator<T> iterator, T value)
 {
  int c = 0;
        while(iterator.hasNext())
        {
            if(iterator.next().equals(value))
            {
                c++;
            }
        }
        return c;
 }
 
 public static <T> int c(T [] array, Predicate<T> pred)
 {
  int c = 0;
  
        for(T arrayValue : array)
        {
            if (arrayValue.equals(pred))
            {
                c++;
            }
        }
        return c;
 }
 
 public static <T> int c(Iterable<T> iterable, Predicate<T> pred)
 {
  int c = 0;
  
     for(T t : iterable)
     {
      if(t.equals(pred))
         {
       c++;
         }
     }
     return c;
 }
 
 public static <T> int c(Iterator<T> iterator, Predicate<T> pred)
 {
  int c = 0;
        while(iterator.hasNext()){
            if(iterator.next().equals(pred))
            {
                c++;
            }
        }
        return c;
 }
 
 public static <T> boolean exists(T[] array, T value)
 {
  for(T arrayValue : array){
            if (arrayValue.equals(value))
            {
                return true;
            }
        }
       return false;
 }
 
 public static <T> boolean exists(Iterable<T> iterable, T value)
 {
  for(T t : iterable){
            if(t.equals(value))
            {
                return true;
            }
        }
        return false;
 }
 
 public static <T> boolean exists(Iterator<T> iterator, T value)
 {
  while(iterator.hasNext()){
            if(iterator.next().equals(value))
            {
                return true;
            }
        }
        return false;
 }
 
 public static <T> boolean exists(T[] array, Predicate<T> pred)
 {
  for(T arrayValue : array){
            if (arrayValue.equals(pred))
            {
                return true;
            }
        }
       return false;
 }
 
 public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred)
 {
  for(T t : iterable){
            if(t.equals(pred))
            {
                return true;
            }
        }
        return false;
 }
 
 public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred)
 {
  while(iterator.hasNext()){
            if(iterator.next().equals(pred))
            {
                return true;
            }
        }
        return false;
 }
 
 public static <T> T find(T[] array, T value)
 {
        final Iterator<T> a = Arrays.stream(array).iterator();
        return find(a, value);
    }
    
    public static <T> T find(Iterable<T> iterable, T value)
    {
        final Iterator <T> a = iterable.iterator();
        return find(a, value);
    }
    
    public static <T> T find(Iterator<T> iterator, T value)
    {
        final Predicate <T> pred = value::equals;
        return find(iterator, pred);
    }
    
    public static <T> T find(T[] array, Predicate<T> pred)
    {
        final Iterator<T> a = Arrays.stream(array).iterator();
        return find(a, pred);
    }
    
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred)
    {
        final Iterator <T> a = iterable.iterator();
        return find(a, pred);
    }
    
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred)
    {
        return find(iterator, pred);
    }
    
    public static <T extends Comparable<? super T>> T max(T first, T second)
    {
        if(first.compareTo(second) > 0)
        {
         return first;
        }
        else
        {
         return second;
        }
    }
    
    public static <T extends Comparable<? super T>> T max(T [] array)
    {
        List<T> list = Arrays.asList(array);
        return Collections.max(list);
    }
    
    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable)
    {
     List<T> list = new ArrayList<T>();
     iterable.forEach(list :: add);
     return Collections.max(list);
    }

    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator)
    {
     List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list :: add);
     return Collections.max(list);
    }
    
    public static <T extends Comparable<? super T>> T max(T first, T second, Comparator<? super T> comparator)
    {
     List<T> list = new ArrayList<T>();
        list.add(first);
        list.add(second);
        return Collections.max(list);
    }
    
    public static <T extends Comparable<? super T>> T max(T [] array, Comparator<? super T> comparator)
    {
      List<T> list = Arrays.asList(array);
         return Collections.max(list, comparator);
    }
    
    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator)
    {
     List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.max(list, comparator);
    }

    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator)
    {
     List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.max(list, comparator);
    }

    public static <T extends Comparable<? super T>> T min(T first, T second)
    {
     if(first.compareTo(second) < 0)
     {
      return first;
     }
     else
     {
      return second;
     }
    }
    
    public static <T extends Comparable<? super T>> T min(T [] array)
    {
     List<T> list = Arrays.asList(array);
        return Collections.min(list);
    }
    
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable)
    {
     List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.min(list);
    }

    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator)
    {
     List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.min(list);
    }
    
    public static <T extends Comparable<? super T>> T min(T first, T second, Comparator<? super T> comparator)
    {
     List<T> list = new ArrayList<T>();
        list.add(first);
        list.add(second);
        return Collections.min(list, comparator);
    }
    
    public static <T extends Comparable<? super T>> T min(T [] array, Comparator<? super T> comparator)
    {
      List<T> list = Arrays.asList(array);
         return Collections.min(list, comparator);
    }
    
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator)
    {
     List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.min(list, comparator);
    }

    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator)
    {
     List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.min(list, comparator);
    }
 
}