package Training;

public class A1 {

    public static int replace(char[] filename)
    {
        int changed = 0;
        int lastDot = 0;
        for(int i = filename.length-1; i>0;i--){
            if(filename[i] == '.'){
                lastDot = i;
                break;
            }
        }

        for(int i = 0; i < filename.length ;i++){
            if(i == lastDot){
                break;
            }

            if(filename[i] == '.'){
                filename[i] = '_';
                changed++;
            }
        }

        return changed;

    }
    public static void main(String[] args){
        char[] filename = "Graphik.Init.Datei.ini".toCharArray();
        System.out.println("Changed chars: "+replace(filename));
        System.out.println(new String(filename));
    }



}
