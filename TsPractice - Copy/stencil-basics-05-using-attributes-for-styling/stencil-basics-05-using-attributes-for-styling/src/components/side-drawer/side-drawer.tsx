import { Component, Prop } from '@stencil/core';

@Component({
  tag: 'uc-side-drawer',
  styleUrl: 'side-drawer.css',
  shadow: true
})
export class SideDrawer {
  @Prop({ reflectToAttr: true }) title: string;
  @Prop({reflectToAttr: true}) open: boolean;

  render() {
    console.log("this is working");
    if(this.open){

      console.log("if condition working")
    }
    else{
      console.log("ifnot working")
    }
    return (
      <aside>
        <header>
          <h1>{this.title}</h1>
        </header>
        <main>
         
        </main>
      </aside>
    );
  }
}
