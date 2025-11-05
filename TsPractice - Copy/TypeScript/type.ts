type TaskStatus = "pending" | "in-progress" | "done";

let task:"pending"|"completed";

//TaskStatus is a custom type
//task is variable with only pending | copmleted as 
task="pending"
//task="in-progress" Type '"in-progress"' is not assignable to type '"completed" | "pending"'.

let t1:TaskStatus="pending"
//let t2:TaskStatus="completed"; Type '"completed"' is not assignable to type 'TaskStatus'.

console.log(task);
console.log(t1);