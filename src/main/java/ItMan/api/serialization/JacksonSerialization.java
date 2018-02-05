package ItMan.api.serialization;

import ItMan.api.entities.Firma;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonSerialization {
    final static Logger logger = Logger.getLogger(JacksonSerialization.class);

    public static void generateFirstJson(ObjectMapper mapper, String fileSuffix) throws IOException {

        logger.info("Start generateFirstJson");
        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);;

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        List<Firma> firmy = objectsCreator.getFirmy();

        //Serialize to file and string
        mapper.writeValue(new File("dump." + fileSuffix), firmy);
        String jsonString = mapper.writeValueAsString(firmy);
        logger.info("Printing serialized original object " + fileSuffix);
        System.out.println(jsonString);


        logger.info("Stop generateFirstJson");

    }

    public static void saveJSON(ObjectMapper jsonMapper, List<Firma> firmy, String fileSuffix){

        logger.info("Start saveJSON");
        try {

//            for (Users user : users) {
//                for (Business busines : user.getBusinesses()) {
//                    for (Passwords password : busines.getPasswords()) {
//                        password.setBusiness(null);
//                    }
//                }
//            }

            //Set mapper to pretty-print
            jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonMapper.registerModule(new JodaModule());
            jsonMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


            //Serialize to file and string
            jsonMapper.writeValue(new File("dump." + fileSuffix), firmy);
            String jsonString = jsonMapper.writeValueAsString(firmy);
            logger.info("Printing serialized original object " + fileSuffix);
            System.out.println(jsonString);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            logger.info("Stop saveJSON");
        }
    }

    public static List<Firma> loadJSON(ObjectMapper mapper, String fileSuffix) throws IOException {

        logger.info("Start loadJSON");

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        //Deserialized employee object from employees.* file in resources
        //InputStream users = JacksonSerialization.class.getClassLoader().getResourceAsStream("dump." + fileSuffix);
        //List<Users> deserializedUsers = mapper.readValue(users, new TypeReference<List<Users>>(){});
        List<Firma> deserializedUsers = mapper.readValue(new File("dump." + fileSuffix), new TypeReference<List<Firma>>(){});
        //String modifiedSerialzied = mapper.writeValueAsString(deserializedUsers);
        logger.info("Printing modified re-serialized employee to" + fileSuffix);
        System.out.println(deserializedUsers.size());
        //new Manager().saveToDatabaseAllDate(deserializedUsers);
        logger.info("Stop loadJSON");
        return deserializedUsers;
    }

    public JacksonSerialization(){

    }

    public static void main(String [ ] args) throws IOException{

        ObjectMapper jsonMapper = new ObjectMapper();
        generateFirstJson(jsonMapper, "json");
        loadJSON(jsonMapper, "json");
        //saveJSON(jsonMapper, new Manager().readFromBaseAllDate(),"json");

        ObjectMapper xmlMapper = new XmlMapper();
        generateFirstJson(xmlMapper, "xml");
        loadJSON(xmlMapper,"xml");
        //saveJSON(xmlMapper,new Manager().readFromBaseAllDate(),"xml");
    }
}
