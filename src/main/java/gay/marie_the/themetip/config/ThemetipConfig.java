package gay.marie_the.themetip.config;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.autogen.*;
import dev.isxander.yacl3.config.v2.api.autogen.Boolean;
import dev.isxander.yacl3.config.v2.api.autogen.Label;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import gay.marie_the.themetip.Themetip;
import jdk.jfr.Category;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.nio.file.Path;
import java.util.List;

public class ThemetipConfig {

    public static final Path configFile = FabricLoader.getInstance().getConfigDir().resolve("themetip.json5");

    private static final String mainConfig = "colors";

    private static final String basic = "basic";
    private static final String tooltipBorder = "border";
    private static final String tooltipBackground = "background";
    private static final String misc = "misc";

    @AutoGen(category = mainConfig, group = basic)
    @MasterTickBox(value = "secondaryColor")
    @SerialEntry
    public static boolean gradient = true;

    @AutoGen(category = mainConfig, group = basic)
    @TickBox
    @SerialEntry
    public static boolean thickEdges = true;

    @AutoGen(category = mainConfig, group = tooltipBorder)
    @ColorField(allowAlpha = true)
    @SerialEntry
    public static Color primaryColor = new Color(1347420415, true);
    // 5000ff


    @AutoGen(category = mainConfig, group = tooltipBorder)
    @ColorField(allowAlpha = true)
    @SerialEntry
    public static Color secondaryColor = new Color(1344798847,true);
    // 28007f

    @AutoGen(category = mainConfig, group = tooltipBackground)
    @ColorField(allowAlpha = true)
    @SerialEntry
    public static Color backgroundColor = new Color(-267386864, true);

    @AutoGen(category = mainConfig, group = misc)
    @MasterTickBox(value = "importantSetting")
    @SerialEntry
    public boolean importantSetting = true;


    public static final ConfigClassHandler<ThemetipConfig> HANDLER = ConfigClassHandler.createBuilder(ThemetipConfig.class)
            .id(Themetip.id("config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(configFile)
                    .appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                    .setJson5(true)
                    .build())
            .build();
}
