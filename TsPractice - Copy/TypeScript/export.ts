export function fun(num:number):number{
    return num*2;
}

class a{
   gender:string;
   constructor()
   {
     this.gender="male";
   }
 name() :string{
    return this.gender;
  }
}

const demo = new a();
console.log(demo.name())

class A{
	  id:number;
	  constructor(){
        this.id=10;
      }
	}

	class B extends A{
        constructor(){
            super();
        }
	  printName():number{
	   return this.id;
	}
	}

const obj1=new B();
console.log(obj1.printName());

