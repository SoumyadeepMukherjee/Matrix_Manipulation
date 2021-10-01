public class flattenArray {

public static void main(String args[]) {

    int inputLists[][] = {{1,2,24},{12,1241,122},{3,2},{7}};

    flattenList(inputLists);

}

public static void flattenList(int input[][]){
    List result = new ArrayList();
    Map<Integer, List<Integer>> elements = new HashMap<Integer,List<Integer>>();
    for(int i=0;i<input.length;i++){
        for(int j=0;j<input[i].length;j++){

            List<Integer> temp = new ArrayList<Integer>();


            if(elements.get(j)!=null) {
                temp=elements.get(j);
                temp.add(input[i][j]);
                elements.put(j, temp);
            }

            else {
                temp.add(input[i][j]);
                elements.put(j,temp);
            }
        }
    }

    for(int i=0;i<input.length;i++){
        if(elements.get(i)!=null)
        result.addAll(elements.get(i));
    }

    for(int i=0;i<result.size();i++){
        System.out.println(result.get(i)+" ");
    }
}
}
