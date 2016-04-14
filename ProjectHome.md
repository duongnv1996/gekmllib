A Java library to ease creation and manipulation of KML files. A KML file can be loaded as simply as this:
Kml kmlRoot = new KMLParser().parse(new File(filename));
Alternatively a Kml document can be built up programmatically, eg by creating new Placemark(), new Folder() etc and adding them to the root, or other Folders.

Kml.toKML() produces the KML document.

KML.toUpdateKML() will produce a KML document representing the updates since toUpdateKML() was last called.

## Note: this project is no longer supported ##
This project hasn't been updated for several years. If you would like to take over the project feel free to message me.

It seems the version of KML used by Google Earth is 2.2 nowadays (March 2011). This library was written for 2.1 so you might not be able to access all elements.