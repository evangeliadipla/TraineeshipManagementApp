package traineeship_app.services.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traineeship_app.domainmodel.Company;
import traineeship_app.domainmodel.Student;
import traineeship_app.domainmodel.TraineeshipPosition;
import traineeship_app.mappers.CompanyMapper;
import traineeship_app.mappers.StudentMapper;
import traineeship_app.mappers.TraineeshipPositionsMapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchBasedOnLocation implements PositionsSearchStrategy {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TraineeshipPositionsMapper traineeshipPositionsMapper;

    public List<TraineeshipPosition> search(String applicantUsername) {
        Student student = studentMapper.findByUsername(applicantUsername);
        if (student == null) {
            throw new IllegalArgumentException("Student not found.");
        }

        String location = student.getPreferredLocation();

        return traineeshipPositionsMapper.findByIsAssignedFalse().stream()
                .filter(position -> {
                    Company company = position.getCompany();
                    boolean locationMatch = company != null &&
                            location != null &&
                            company.getCompanyLocation().equalsIgnoreCase(location.trim());

                    return locationMatch;
                })
                .collect(Collectors.toList());
    }


    // Helper function to parse comma-separated strings into lists of strings
    private List<String> parseTags(String input) {
        return input != null ? Arrays.asList(input.split("\\s*,\\s*")) : List.of();
    }

}