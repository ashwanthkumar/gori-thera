package in.ashwanthkumar;

import org.apache.avro.Schema;
import org.apache.avro.compiler.specific.SpecificCompiler;

import java.io.File;
import java.io.IOException;

public class GoriCompiler extends SpecificCompiler {
    public GoriCompiler(Schema schema) {
        super(schema);
    }

    @Override
    public String javaUnbox(Schema schema) {
        switch (schema.getType()) {
            case INT:
                return "Integer";
            case LONG:
                return "Long";
            case FLOAT:
                return "Float";
            case DOUBLE:
                return "Double";
            case BOOLEAN:
                return "Boolean";
            default:
                return javaType(schema);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("USAGE: GoriCompiler SchemaLocation OutputDirLocation");
            System.exit(-1);
        }

        String schemaLocation = args[0];
        String destinationLocation = args[1];
        GoriCompiler compiler = new GoriCompiler(Schema.parse(new File(schemaLocation)));
        compiler.setTemplateDir("gori-compiler/src/main/velocity/");
        compiler.compileToDestination(new File(schemaLocation), new File(destinationLocation));


    }
}
