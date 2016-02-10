
public class AccessList {
     public String mayAccess(int[] rights, int minPermission) {
    	 String access = ""; // 123 2 DAA
    	 for(int k = 0; k < rights.length; k++)
    	 {
    		 if(rights[k] >= minPermission)
    		 {
    			 access += "A"; //return A if meet the minimum permission 
    	     } 
    		 else 
    	     {
    			 access += "D"; //return D if not meet the minimum permission
    	     }
    	 }
    	 return access;
     }
}
