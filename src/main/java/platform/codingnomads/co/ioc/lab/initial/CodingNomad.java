package platform.codingnomads.co.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {

    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;

    private OS os;

    @Autowired
    public void setOs(OS os) {
        this.os = os;
    }

    @Autowired
    SSDHarddrive ssdHarddrive;

    public String createAwesomeSoftware() {
        return MessageFormat
                .format("This codingnomad is creating awesome software using, " +
                        "IDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5}), OS: ({6}:{7}), SSD Harddrive: ({8}:{9})",
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion(),
                        os.getName(),
                        os.getVerison(),
                        ssdHarddrive.getName(),
                        ssdHarddrive.getCapacity()
                );
    }
}
