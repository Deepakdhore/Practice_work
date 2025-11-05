
interface Song{
    id:number;
    name:string;
}

function updateName(song:Song, fieldsToUpdate: Partial<Song>){
    return {...song, ...fieldsToUpdate};
}

const obj1= {
    id:10,
    name:"old song",
};

const obj2= updateName( obj1,{name:"new song"});

console.log(obj2);
