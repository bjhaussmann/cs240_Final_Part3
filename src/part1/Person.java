/**
 * 
 */
package part1;

/**
 * @author bjhau
 *
 */
/*************************************************************************
 * Winter 2017 CS 240 Programming Exam : Person
 * 
 * Author: Haussmann, Ben
 * 
 * Dependencies: Stack, Queue, Dictionary
 * 
 * Description: Models a person, a list of messages that they can read, and a
 * list of their friends, so that when you post a message, all your friends can
 * read it too.
 * 
 **************************************************************************/

public class Person {
	private String name;
	private StackLinked <String> messages;
	private StackLinked<Person> friends;

	// Create a new Person with this name.
	public Person(String name) {
		this.name = name;
		messages = new StackLinked <String>();
		friends = new StackLinked<Person>();
	}

	// Make these two people become friends with each other.
	// Throw an exception if you try to meet yourself.
	// We are allowed to assume we didn't meet this person yet.
	public void meet(Person otherPerson) {
		if (otherPerson == this) {
			throw new RuntimeException();
		} else {
			friends.push(otherPerson);
			otherPerson.friends.push(this);;
		}
	}

	// Are these two people friends?
	// Throw an exception if you ask about knowing yourself.
	public boolean knows(Person otherPerson) {
		if (otherPerson == this) {
			throw new RuntimeException();
		} else if (friends.isEmpty())
		{
			return false;
		}else {
			boolean ans = false;
			StackLinked <Person> temp = new StackLinked <Person> (); // Since can't use iterators
			while (!friends.isEmpty())
			{
				temp.push(friends.pop());
			}
			while(!temp.isEmpty())
			{
				if(temp.peek() == otherPerson)
				{
					ans = true;
				}
				friends.push(temp.pop());
			}
			return ans;
		}
	}

	// Post a message to my list and the lists of all my friends
	public void post(String message) {
		messages.push(message);
		
		StackLinked <Person> temp = new StackLinked <Person>(); // Since can't use iterators
		while (!friends.isEmpty())
		{
			temp.push(friends.pop());
		}
		while(!temp.isEmpty())
		{
			temp.peek().messages.push(message);
			friends.push(temp.pop());
		}
	}

	// Print a header, then all messages this Person can read, newest first
	public void listMessages() {
		System.out.println("== The Wall of " + name + " ==");
		StackLinked <String> temp = new StackLinked <String>(); //No iterators.
		while (!messages.isEmpty())
		{
			System.out.println(messages.peek());
			temp.push(messages.pop());
		}
		while (!temp.isEmpty())
		{
			messages.push(temp.pop());
		}
	}
}