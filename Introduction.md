# Introduction #

Welcome to the gekmllib project, a Java library designed to ease the creation and manipulation of KML for Google Earth.

This is version 0.03 of the library, it's nowhere near a complete implementation.

# News #

Source now in SVN.

Documentation in docs dir in SVN, will make it into next Jar release.

# Details #

The classes are designed so that you can only add correct elements to each other, eg you can't add a GroundOverlay to a Placemark. There is currently no Schema validation carried out.

# Current Limitations #
No convenient constructors, all classes use empty constructor, and are then initialised using getters and setters (as per Bean spec).

There is currently no Schema validation carried out.

**Note: No longer requires Java 5**

CHANGELOG

Version 0.03

---

Made Java 1.4 compliant (this changed API)

Removed all StringBuilder refs (Java compiler converts String append to these anyway)

Added ability to turn off autogeneration of IDs in KML Objects (Configuration class)

Added basic functionality to LongDate, now supports years as BigIntegers

Fixed error outputting coordinates (commas and spaces mixed up)

Added 4 separate examples (pip.