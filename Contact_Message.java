
package project_classes;


public class Contact_Message implements Message{

    @Override
    public String getBody() {
        String info= "|Name: "+sender.getName()+"|PhoneNumber: "+sender.getPhoneNumber()
                +"|Email: "+sender.getEmail()+"|";
        ContactMessage_DB_Interface cdb=new ContactMessage_DB_Interface();
        cdb.addContactMessage(this);
        return info;
    }
    
}

