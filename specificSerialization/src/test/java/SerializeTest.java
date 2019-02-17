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

        Circle c1 = new Circle("ONEcolorCircle", 1);
        Triangle t2 = new Triangle("TWOcolorTrianlge", 2);
        g2.addFigures(t2);
        g1.addFigures(c1);
        g1.addAll(g2);

        String expectedResult = "\n" +
                "<Circle>\n" +
                "\t<String>\n" +
                "\t\t<name>color</name>\n" +
                "\t\t<value>ONEcolorCircle</value>\n" +
                "\t</String>\n" +
                "\t<int>\n" +
                "\t\t<name>size</name>\n" +
                "\t\t<value>1</value>\n" +
                "\t</int>\n" +
                "\t<method>fill</method>\n" +
                "\t<method>draw</method>\n" +
                "</Circle>\n" +
                "<InnerGroupLevel 1>\n" +
                "\t<Triangle>\n" +
                "\t\t<String>\n" +
                "\t\t\t<name>color</name>\n" +
                "\t\t\t<value>TWOcolorTrianlge</value>\n" +
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

        Circle c1 = new Circle("ONEcolorCircle", 1);
        Triangle t2 = new Triangle("TWOcolorTrianlge", 2);
        g2.addFigures(t2);
        g1.addFigures(c1);
        g1.addAll(g2);

        String expectedResult = "{\n" +
                "\"Circle\" : {\n" +
                "\t\"color\": \"ONEcolorCircle\",\n" +
                "\t\"size\": \"1\",\n" +
                "\t\"fill\" : {\n" +
                "\t}\n" +
                "\n" +
                "\t\"draw\" : {\n" +
                "\t}\n" +
                "}\n" +
                "\t{\n" +
                "\t\"Triangle\" : {\n" +
                "\t\t\"color\": \"TWOcolorTrianlge\",\n" +
                "\t\t\"size\": \"2\",\n" +
                "\t\t\"fill\" : {\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t\"draw\" : {\n" +
                "\t\t}\n" +
                "\t}\n";

        Assert.assertEquals(expectedResult, SerializeToJson.serialize(g1));
    }
}