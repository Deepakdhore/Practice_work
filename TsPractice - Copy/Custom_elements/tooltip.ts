
//to be usable we extend
//HTMLElement {base class} element
//every custom html elemnt must extend a {base class}  
class Tooltip extends HTMLElement{
//task hover->display
    constructor(){
        super();
        console.log('it is working');
    }

}
//atleast one ('-') is required here (name,className);
customElements.define('amiti-tooltip',Tooltip);
