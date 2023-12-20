package main

import "fmt"

func main() {

	//Problem 2
	fmt.Println("Hello World!")
	m := Constructor()
	m.Push(5)
	m.Push(10)
	m.Push(11)
	m.Push(1)
	m.Push(7)
	fmt.Println(m)
	fmt.Println(m.Pop())
	fmt.Println(m.Peek())
	fmt.Println(m.Empty())

	//Problem 1

}
