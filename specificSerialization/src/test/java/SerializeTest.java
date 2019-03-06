import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SerializeTest {
    Group g1;


    @Before
    public void init() {
        g1 = new Group();
        Group g2 = new Group();

        Circle c1 = new Circle("1_Black", 1);
        Triangle t2 = new Triangle("2_Blue", 2);
        Triangle t3 = new Triangle("3_Pink", 2);
        Triangle t4 = new Triangle("4_Yellow", 2);
        Triangle t5 = new Triangle("5_Cyan", 2);
        g1.addFigures(t2, c1);
        g2.addFigures(t3,t4,t5);

        g1.addAll(g2);
    }

    @Test
    public void testOutputOfXmlSerialize() {


        String expectedResult = "<figures>\n" +
                "\t<Triangle>\n" +
                "\t\t<String>\n" +
                "\t\t\t<name>color</name>\n" +
                "\t\t\t<value>2_Blue</value>\n" +
                "\t\t</String>\n" +
                "\t\t<int>\n" +
                "\t\t\t<name>size</name>\n" +
                "\t\t\t<value>2</value>\n" +
                "\t\t</int>\n" +
                "\t\t<method>fill</method>\n" +
                "\t\t<method>draw</method>\n" +
                "\t</Triangle>\n" +
                "\t<Circle>\n" +
                "\t\t<String>\n" +
                "\t\t\t<name>color</name>\n" +
                "\t\t\t<value>1_Black</value>\n" +
                "\t\t</String>\n" +
                "\t\t<int>\n" +
                "\t\t\t<name>size</name>\n" +
                "\t\t\t<value>1</value>\n" +
                "\t\t</int>\n" +
                "\t\t<method>fill</method>\n" +
                "\t\t<method>draw</method>\n" +
                "\t</Circle>\n" +
                "</figures>\n" +
                "<childGroups>\n" +
                "\t<figures>\n" +
                "\t\t<Triangle>\n" +
                "\t\t\t<String>\n" +
                "\t\t\t\t<name>color</name>\n" +
                "\t\t\t\t<value>3_Pink</value>\n" +
                "\t\t\t</String>\n" +
                "\t\t\t<int>\n" +
                "\t\t\t\t<name>size</name>\n" +
                "\t\t\t\t<value>2</value>\n" +
                "\t\t\t</int>\n" +
                "\t\t\t<method>fill</method>\n" +
                "\t\t\t<method>draw</method>\n" +
                "\t\t</Triangle>\n" +
                "\t\t<Triangle>\n" +
                "\t\t\t<String>\n" +
                "\t\t\t\t<name>color</name>\n" +
                "\t\t\t\t<value>4_Yellow</value>\n" +
                "\t\t\t</String>\n" +
                "\t\t\t<int>\n" +
                "\t\t\t\t<name>size</name>\n" +
                "\t\t\t\t<value>2</value>\n" +
                "\t\t\t</int>\n" +
                "\t\t\t<method>fill</method>\n" +
                "\t\t\t<method>draw</method>\n" +
                "\t\t</Triangle>\n" +
                "\t\t<Triangle>\n" +
                "\t\t\t<String>\n" +
                "\t\t\t\t<name>color</name>\n" +
                "\t\t\t\t<value>5_Cyan</value>\n" +
                "\t\t\t</String>\n" +
                "\t\t\t<int>\n" +
                "\t\t\t\t<name>size</name>\n" +
                "\t\t\t\t<value>2</value>\n" +
                "\t\t\t</int>\n" +
                "\t\t\t<method>fill</method>\n" +
                "\t\t\t<method>draw</method>\n" +
                "\t\t</Triangle>\n" +
                "\t</figures>\n" +
                "\t<childGroups>\n" +
                "\t</childGroups>\n" +
                "</childGroups>\n";

        Assert.assertEquals(expectedResult, SerializeToXml.serialize(g1));
    }

    @Test
    public void testOutputJsonSerialize() {

        String expectedResult = "{\n" +
                "  \"figures\": [\n" +
                "    {\n" +
                "      \"color\": \"2_Blue\",\n" +
                "      \"size\": \"2\",\n" +
                "      \"fill\": {},\n" +
                "      \"draw\": {},\n" +
                "    },\n" +
                "    {\n" +
                "      \"color\": \"1_Black\",\n" +
                "      \"size\": \"1\",\n" +
                "      \"fill\": {},\n" +
                "      \"draw\": {},\n" +
                "    },\n" +
                "  ], \n" +
                "  \"childGroups\": [\n" +
                "    {\n" +
                "      \"figures\": [\n" +
                "        {\n" +
                "          \"color\": \"3_Pink\",\n" +
                "          \"size\": \"2\",\n" +
                "          \"fill\": {},\n" +
                "          \"draw\": {},\n" +
                "        },\n" +
                "        {\n" +
                "          \"color\": \"4_Yellow\",\n" +
                "          \"size\": \"2\",\n" +
                "          \"fill\": {},\n" +
                "          \"draw\": {},\n" +
                "        },\n" +
                "        {\n" +
                "          \"color\": \"5_Cyan\",\n" +
                "          \"size\": \"2\",\n" +
                "          \"fill\": {},\n" +
                "          \"draw\": {},\n" +
                "        },\n" +
                "      ], \n" +
                "      \"childGroups\": []\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";

        Assert.assertEquals(expectedResult, SerializeToJson.serialize(g1));
    }
}