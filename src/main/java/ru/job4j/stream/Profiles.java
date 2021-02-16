package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        Comparator<Address> comparator = (o1, o2) -> o1.getCity().compareTo(o2.getCity());
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(comparator)
                .distinct()
                .collect(Collectors.toList());
    }
}
