import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SerializeTest {

    @Test
    public void testOutputOfXmlSerialize() {
        Group g1 = new Group();
        Group g2 = new Group();


        Circle c1 = new Circle("1_Black", 1);
        Triangle t2 = new Triangle("2_Blue", 2);
        Triangle t3 = new Triangle("3_Pink", 2);
        Triangle t4 = new Triangle("4_Yellow", 2);
        Triangle t5 = new Triangle("5_Cyan", 2);
        g1.addFigures(t2, c1);
        g2.addFigures(t3,t4,t5);

        g1.addAll(g2);

        String expectedResult = "\n" +
                "<Group>\n" +
                "<sb>\n" +
                "<list>()()</list> \n" +
                "<childGroups>()</childGroups>\n" +
                "</Group>\n" +
                "<Triangle>\n" +
                "\t<String>\n" +
                "\t\t<name>color</name>\n" +
                "\t\t<value>2_Blue</value>\n" +
                "\t</String>\n" +
                "\t<int>\n" +
                "\t\t<name>size</name>\n" +
                "\t\t<value>2</value>\n" +
                "\t</int>\n" +
                "\t<method>fill</method>\n" +
                "\t<method>draw</method>\n" +
                "</Triangle>\n" +
                "<Circle>\n" +
                "\t<String>\n" +
                "\t\t<name>color</name>\n" +
                "\t\t<value>1_Black</value>\n" +
                "\t</String>\n" +
                "\t<int>\n" +
                "\t\t<name>size</name>\n" +
                "\t\t<value>1</value>\n" +
                "\t</int>\n" +
                "\t<method>fill</method>\n" +
                "\t<method>draw</method>\n" +
                "</Circle>\n" +
                "<InnerGroupLevel 1>\n" +
                "<Group>\n" +
                "<sb>\n" +
                "<list>()()()</list> \n" +
                "<childGroups></childGroups>\n" +
                "</Group>\n" +
                "\t<Triangle>\n" +
                "\t\t<String>\n" +
                "\t\t\t<name>color</name>\n" +
                "\t\t\t<value>3_Pink</value>\n" +
                "\t\t</String>\n" +
                "\t\t<int>\n" +
                "\t\t\t<name>size</name>\n" +
                "\t\t\t<value>2</value>\n" +
                "\t\t</int>\n" +
                "\t\t<method>fill</method>\n" +
                "\t\t<method>draw</method>\n" +
                "\t</Triangle>\n" +
                "\t<Triangle>\n" +
                "\t\t<String>\n" +
                "\t\t\t<name>color</name>\n" +
                "\t\t\t<value>4_Yellow</value>\n" +
                "\t\t</String>\n" +
                "\t\t<int>\n" +
                "\t\t\t<name>size</name>\n" +
                "\t\t\t<value>2</value>\n" +
                "\t\t</int>\n" +
                "\t\t<method>fill</method>\n" +
                "\t\t<method>draw</method>\n" +
                "\t</Triangle>\n" +
                "\t<Triangle>\n" +
                "\t\t<String>\n" +
                "\t\t\t<name>color</name>\n" +
                "\t\t\t<value>5_Cyan</value>\n" +
                "\t\t</String>\n" +
                "\t\t<int>\n" +
                "\t\t\t<name>size</name>\n" +
                "\t\t\t<value>2</value>\n" +
                "\t\t</int>\n" +
                "\t\t<method>fill</method>\n" +
                "\t\t<method>draw</method>\n" +
                "\t</Triangle>\n" +
                "</InnerGroupLevel 1>";

        Assert.assertEquals(expectedResult, SerializeToXml.serialize(g1));
    }

    @Test
    public void testOutputJsonSerialize() {
        Group g1 = new Group();
        Group g2 = new Group();


        Circle c1 = new Circle("1_Black", 1);
        Triangle t2 = new Triangle("2_Blue", 2);
        Triangle t3 = new Triangle("3_Pink", 2);
        Triangle t4 = new Triangle("4_Yellow", 2);
        Triangle t5 = new Triangle("5_Cyan", 2);
        g1.addFigures(t2, c1);
        g2.addFigures(t3,t4,t5);

        g1.addAll(g2);

        String expectedResult = "\"sb\",  \"list\": [{}{}] ,  \"childGroups\": [{}] , : \n" +
                "{\"color\": \"2_Blue\",\"size\": \"2\", \"fill\" : {} \"draw\" : {}}\n" +
                "\n" +
                "{\"color\": \"1_Black\",\"size\": \"1\", \"fill\" : {} \"draw\" : {}}\n" +
                "\"sb\",  \"list\": [{}{}{}] ,  \"childGroups\": [] , : \n" +
                "{\"color\": \"3_Pink\",\"size\": \"2\", \"fill\" : {} \"draw\" : {}}\n" +
                "\n" +
                "{\"color\": \"4_Yellow\",\"size\": \"2\", \"fill\" : {} \"draw\" : {}}\n" +
                "\n" +
                "{\"color\": \"5_Cyan\",\"size\": \"2\", \"fill\" : {} \"draw\" : {}}\n";

        Assert.assertEquals(expectedResult, SerializeToJson.serialize(g1));
    }
}