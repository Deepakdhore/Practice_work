import { Component, Prop ,h } from '@stencil/core';

@Component({
  tag: 'am-side-drawer',
  styleUrl: './side-drawer.css',
  shadow: true
})
export class SideDrawer {
  @Prop({ reflect: true }) title: string;
  @Prop({reflect:true}) open: boolean;
  onClickdrawer(){

      this.open=true;
  }  

  render() {
    // let content = null;
    // if (this.open) {
    //   content = (
    //     <aside>
    //       <header>
    //         <h1>{this.title}</h1>
    //       </header>
    //       <main>
    //         <slot />
    //       </main>
    //     </aside>
    //   );
    // }
    return (
      <aside>
        <header>
          <h1>{this.title}</h1>
          <button onClick={this.onClickdrawer}>x</button>
        </header>
        <main>
          <slot />
        </main>
      </aside>
    );
  }
}
