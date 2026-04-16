class Solution {

    public String encode(List<String> strs) {
     StringBuilder sb = new StringBuilder();
     for(int i=0; i<strs.size(); i++){
        String s = strs.get(i);
        sb.append(s.length());
        sb.append("#");
        sb.append(s);
     }
     return sb.toString();
    }

    public List<String> decode(String str) {
     List<String>res = new ArrayList<>();
     int i = 0;
     while(i < str.length()){
        int hashIndex = str.indexOf("#",i);
        int length = Integer.parseInt(str.substring(i,hashIndex));
        String word = str.substring(1+hashIndex,hashIndex+1+length);
        res.add(word);
        i=hashIndex+1+length;
     }
     return res;
    }
}
