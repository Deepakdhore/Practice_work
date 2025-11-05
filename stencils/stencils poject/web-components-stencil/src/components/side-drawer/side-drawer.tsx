import { Component, h, Prop } from '@stencil/core';

@Component({
  tag: 'uc-side-drawer',
  styleUrl: './side-drawer.css',
  shadow: true
})
export class SideDrawer {
  @Prop({ reflect: true }) drawerTitle: string;

  render() {
    return (
      <aside>
        <header><h1>{this.drawerTitle}</h1></header>
        <main>
          <slot />
        </main>
      </aside>
    );
  }
}
