class Tooltip extends HTMLElement{

    constructor(){
        super();
        this._tooltipContainer; // making it global since underscore == private

    }
    
    connectedCallback(){
        this._tooltipText=this.getAttribute('tooltipText');
        const tooltipIcon=document.createElement('span');
        tooltipIcon.textContent=' (????)';
        
        tooltipIcon.addEventListener('mouseenter',this._showTooltip.bind(this));
        tooltipIcon.addEventListener('mouseleave',this._hideTooltip.bind(this));
        this.appendChild(tooltipIcon);
    }
    //underscorse = private;
    _showTooltip(){
        this._tooltipContainer = document.createElement('div');
        if(!this._tooltipText)
        {
            this._tooltipText="dummy text";
        }
        //this._tooltipContainer.textContent="this is tooltip div called when hovered";
        this._tooltipContainer.textContent=this._tooltipText;
        this.appendChild(this._tooltipContainer);
    }
    _hideTooltip(){
        this.removeChild(this._tooltipContainer);
    }
}
//atleast one ('-') is required here (name,className);
customElements.define('amiti-tooltip',Tooltip);


/* first i created a class
    extendede it to HTMLElements class(base class)
    in the class added constrcutor with 
        super and console.log
    next set upa the tag name as (smallname - fullname),
        then created  index.html and added the custom tag whit the name i created
            run =console.log
    next i created aan element corresponding to the tag
        -but unable because
            -The element is created, but not yet inserted into the document (<body>, etc.).
            -You cannot safely access children, layout info, or styles.
            -You shouldn't manipulate the DOM yet — it's meant only for setup.
        -so created a connectedCallback (1 of lifecycle)
            -then HERE i created a span element
            -sotred it in a const
            -used thihs const as a event listner
            -then addedd two paeameters ('ACTION',funtion.Bind(this));
            -appendChile(const);
                -here fo rthe 'funtion' i gave PRIVATE(_)
                -then created a div element becasue i can 
                -then i gave the div the textContent as = "this is a div being created due to your actions"
                -dont forget to append this child(TOOLTIP "DIV")
            - now evrry time i did an action a new dv was created
            - so i created another PRIAVTE funtion to hide the it
                -since the SHOW FUN is PRIAVTE then how to get that const:
                - s made it global(SORT OF ) by giving ts declarations as 
                    -this._NAME in th CONSTRUCTOR.
                - so i can call the div elemnt by calling _NAME
            - so i added the a event lisner and destroyed!!!!! it YEAAHHHHH
            so it was gone 


now lets talk about ATTRIBUTES so what ar attributes("href"<---this)
    where its like  a custom html elemen t whihc is inbuilt:
now lets add custom ATTRIBUTES (CAN BE CUSTOM NAME TOOOOO)
    like <custom-tag attriName="Text/NUmber/boolean / URL(src=link,mp3,mp4"/ json(Array/data)>
    created a index. html */