package Model;

import Model.Film;
import org.json.simple.JSONObject;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Documents {
    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
    private String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }
    public List<String[]> convertFilmListToStringArrayList(List<Film> films){
        List<String[]> list=new ArrayList<>();
        String[] strings;
        for (Film film: films) {
            strings=new String[5];
            strings[0]= "IdFilm: "+film.getIdFilm();
            strings[1]= "Nume: "+film.getNume();
            strings[2]= "Categorie: "+film.getCategorie();
            strings[3]="Tip: "+film.getTip();
            strings[4]="An Realizare: "+film.getAnRealizare();
            list.add(strings);
        }
        System.out.println(list.get(0)[0]);
        return list;
    }
    public void convertCSVFile(List<String[]> dataLines)  {
        File csvOutputFile = new File("csv file");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

   public void createJSONFile(List<Film> films)  {

        //Inserting key-value pairs into the json object
        FileWriter file = null;
        try {
            file = new FileWriter("output.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            file.append("[");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(Film film :films) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID", film.getIdFilm());
            jsonObject.put("Nume", film.getNume());
            jsonObject.put("Categorie", film.getCategorie());
            jsonObject.put("Tip", film.getTip());
            jsonObject.put("Anul realizarii", film.getAnRealizare());
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("employee",jsonObject);
            try {
                file.append(jsonObject2.toJSONString());
                if(!film.equals(films.get(films.size()-1)))
                    file.append(",\n");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }}
        try {
            file.append("]");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void createCSVFile(List<String[]> films) {


        File csvFile = new File("csfFile.csv");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(csvFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //write header line here if you need.

        for (String[] data : films) {
            StringBuilder line = new StringBuilder();
            System.out.println(data.length);
            for (int i = 0; i < data.length; i++) {
                line.append("\"");
                line.append(data[i].replaceAll("\"","\"\""));
                line.append("\"");
                if (i != data.length - 1) {
                    line.append(',');
                }
            }
            line.append("\n");
            try {
                fileWriter.write(line.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void createXmlDocument(String fileInfo,List<Film> films) {

        XMLOutputFactory factory = XMLOutputFactory.newFactory();

        FileOutputStream fos;
        XMLStreamWriter writer = null;

        try {

            fos = new FileOutputStream(fileInfo);
            writer = factory.createXMLStreamWriter(fos, "UTF-8");
        }
        catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        catch (XMLStreamException e) {

            e.printStackTrace();
        }

        writeToDocumentXML(writer,films);

    }

    public  void writeToDocumentXML(XMLStreamWriter writer, List<Film> films) {

        try {

            writer.writeStartDocument();
            writer.writeCharacters("\n");
            writer.writeStartElement("films");
            writer.writeCharacters("\n");

            for(Film film : films) {

                writer.writeCharacters("\t");
                writer.writeStartElement("film");
                writer.writeAttribute("idFilm", String.valueOf(film.getIdFilm()));

                writer.writeCharacters("\n\t\t");
                writer.writeStartElement("nume");
                writer.writeCharacters(film.getNume());
                writer.writeEndElement();

                writer.writeCharacters("\n\t\t");
                writer.writeStartElement("tip");
                writer.writeCharacters(film.getTip());
                writer.writeEndElement();

                writer.writeCharacters("\n\t\t");
                writer.writeStartElement("categorie");
                writer.writeCharacters(film.getCategorie());
                writer.writeEndElement();

                writer.writeCharacters("\n\t\t");
                writer.writeStartElement("anRealizare");
                writer.writeCharacters(film.getAnRealizare());
                writer.writeEndElement();

                writer.writeCharacters("\n\t");
                writer.writeEndElement();
                writer.writeCharacters("\n");
            }

            writer.writeEndElement();
            writer.writeEndDocument();
            writer.close();

        } catch (XMLStreamException e) {

            e.printStackTrace();
        }
    }
    public void writeToTXTFIle(List<String[]> films) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("FilmTxtFile");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for(String[] strings:films ) {
            for (String string : strings) {
                printWriter.print(string+" ");
            }
            printWriter.print("\n");
        }
        // printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();
    }
}
