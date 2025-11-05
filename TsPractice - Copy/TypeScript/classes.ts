import {Data} from "./interfaces";
  class Point implements Data{
    x: number;
    y: number;

    readonly id:number;
    name:string;
    age: number;

    constructor(){
        this.x=10;
        this.y=20;
        this.id=30;
        this.age=10;
        this.name="Deepak"
    }

  }

  const pt = new Point();
  console.log(pt);

