package com.advance.advancebank;

import org.dom4j.Element;
import org.jivesoftware.whack.ExternalComponentManager;
import org.xmpp.component.Component;
import org.xmpp.component.ComponentManager;
import org.xmpp.packet.IQ;
import org.xmpp.packet.JID;
import org.xmpp.packet.Packet;

/**
 *
 * @author tunjiakinde
 */
public class AdvanceComponent implements Component{

    private ExternalComponentManager mgr = null;

    public String getName() {
        return "US Weather";
    }

    public String getDescription() {
        return "Weather component - sample component";
    }

    public void processPacket(Packet packet) {
        
        System.out.println("Received package:"+packet.toXML());
       
       if(packet instanceof org.xmpp.packet.Message)
       {
           
       }
       
        if (packet instanceof org.xmpp.packet.IQ)
        { 
            
                    IQ iq = (IQ)packet;
              Element iqElem = iq.getChildElement();
              if ("query".equals(iqElem.getName()) && "http://jabber.org/protocol/disco#info".equals(iqElem.getNamespaceURI()))
              {
                 IQ reply = IQ.createResultIQ(iq);
                 Element discoInfo = reply.setChildElement("query", "http://jabber.org/protocol/disco#info");
                    //Construct the reply as in previous section
                    discoInfo.addElement("identity")
                     .addAttribute("category", "banking")
                     .addAttribute("type", "component")
                     .addAttribute("name", "advance component");

                    discoInfo.addElement("feature")
                    .addAttribute("var", "urn:xmpp:advanceComponent");

                    discoInfo.addElement("feature")
                    .addAttribute("var", "urn:xmpp:payBills");

                    discoInfo.addElement("feature")
                    .addAttribute("var", "urn:xmpp:mobileTopUp");
                    //Send the reply
                    System.out.println("Reply:"+reply);
                    mgr.sendPacket(this, reply);
              } 
        }
       
    }

    public void initialize(JID jid, ComponentManager componentManager)
    {
        mgr = (ExternalComponentManager) componentManager;
    }

    public void start() {
    }

    public void shutdown() {
    }
    
}
