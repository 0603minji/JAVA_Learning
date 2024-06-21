package lecture;



public class code_0612 {
    public static void main(String[] args) {
        // 기본형이 아닌 것은 접근법이 따로 있다
        // 객체 : 생성자로 생성

        String greeting1 = new String("Hello");
        String greeting2 = "Hello";
        String greeting3 = "Hello";

        System.out.println(greeting1 == greeting2);
        System.out.println(greeting2 == greeting3);

        String name1 = "아이유";
        String name2 = new String("아이유");
        System.out.println(name1 == name2);

        String filename = "photo.jpg";
        System.out.println(filename.length());
        System.out.println(filename.indexOf("."));
        System.out.println(filename.substring(0, 3));

        String content = """
                <section>
                <h1>긴급속보</h1>
                <div>
                동해상에 오징어가 찾아왔어요~~
                </div>
                </section>
                """;

        int startIndex = content.indexOf("<div>");
        int endIndex = content.indexOf("</div>");
        String result = content.substring(startIndex + "<div>".length(), endIndex).trim();
        System.out.println(result);

        String file = "aaa.png";
        int dotIndex = file.indexOf(".");
        String name = file.substring(0, dotIndex);
        System.out.println(name);
        System.out.println(name.concat(".jpg").concat("hahaha"));

        String con = """
                <section>
                    <h1>새로운 소식 공지입니다.</h1>
                    <div>
                        오늘 하루만 특별히….
                    </div>
                    <div>
                        오징어를 반값에….
                    </div>
                </section>
                """;

        int start = con.lastIndexOf("<div>") + "<div>".length();
        int last = con.lastIndexOf("</div>");

        String res = con.substring(start, last);
        System.out.println(res.trim());
    }

}
