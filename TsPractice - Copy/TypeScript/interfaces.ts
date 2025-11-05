export interface Data{
    readonly id:number ;
    name:string;
    gender_male?:boolean;
    age:number;
}

let data:Data ={
    id:9,
    name:"deepak",
   // gender_male:true, (optional);
    age:23
};
//data.id=20; cannt assign readonly

console.log(data);