
const buildTheButton=()=>{
    const snapBtn=document.querySelector(".snapReplyBtn");
    if(snapBtn)snapBtn.remove();

    const toolbar=findToolBar();

    if(!toolbar){
        console.log("toolbar not found!!!");
        return;
    }
    const snapReplyBtn=createBtn();
    snapReplyBtn.classList.add(".snapReplyBtn");
    snapReplyBtn.addEventListener('click',async()=>{
        try{
            snapReplyBtn.innerHTML="Generating...";
            snapReplyBtn.disabled=true;

            const emailContent=getEmailContent();
            const response=await fetch("https://snapreplybackend.onrender.com/api/generate",{
                method:"POST",
                headers:{
                    'Content-Type':"application/json",
                },
                body:JSON.stringify({
                    "content":emailContent,
                    "type":"formal"
                })
            })
            console.log(emailContent);
            if(!response.ok){
                throw new Error("Api Error!!!");
            }
            const generatedReply=await response.text();
            console.log(generatedReply);
            const composeBox=document.querySelector('[role="textbox"][g_editable="true"]')
            if(composeBox){
                composeBox.focus();
                document.execCommand('insertText', false, generatedReply)
                
            }else{
                console.log("cannot find Compose box ")
            } 
        }catch(e){
            console.log(e);
            alert("Failed to generate the reply");
        }finally{
            snapReplyBtn.innerHTML="SnapReply";
            snapReplyBtn.disabled=false;
        }
    });
    toolbar.insertBefore(snapReplyBtn,toolbar.firstChild);
}

const createBtn=()=>{
    const button=document.createElement('div');
    button.className="T-I J-J5-Ji aoO v7 T-I-atl L3"
    button.style.marginRight = '8px';
    button.style.backgroundColor = 'red';
    button.style.borderRadius="10px"
    button.innerHTML="SnapReply"
    button.setAttribute("role","button");
    button.setAttribute("data-tooltip","Generate AI Reply");
    return button;
}

const getEmailContent=()=>{
    const selectors=[
        '.a3s.aiL',
        '.h7',
        'gmail_quote',
        '[role="presentation"]'
    ]
    for(const selector of selectors){
        const content=document.querySelector(selector);
        
        if(content){
            console.log(selector)
            return content.innerHTML.trim();
        }

    }
    return null;
}

const findToolBar=()=>{
    const selectors=[
        '.btC',
        '.aDh',
        '[role="toolbar"]',
        '.gU.Up'
    ]
    for(const selector of selectors){
        const toolbar=document.querySelector(selector);
        if(toolbar){
            return toolbar;
        }
    }
    return null;
}

const mutationObserver=new MutationObserver((mutations)=>{
    for(const mutation of mutations){
        const updatedNodes=Array.from(mutation.addedNodes);
        const hasComposedNodes=updatedNodes.some((node)=>
            (node.nodeType===Node.ELEMENT_NODE && (node.matches('.aDh,.btC,[role="dialog"]') || node.querySelector('.aDh,.btC,[role="dialog"]')))
        )
        if(hasComposedNodes){
            console.log("button enjected!!!")
            buildTheButton();
        }
    }
})
mutationObserver.observe(document.body,{
    childList:true,
    subtree:true
});