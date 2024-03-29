package com.keithpower.gekmlib;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.keithpower.gekmlib.*;


public class KMLParser
{
    private Digester digester;
    
    public KMLParser()
    {
	this("kml", Kml.class);
    }
    
    public KMLParser(String rootPath, Class rootClass)
    {
	this.digester = new Digester();
	this.digester.setValidating( false );
	setupRules(rootPath, rootClass);
    }
        
    public void setupRules(String rootPath, Class rootClass)
    {
	String [] StyleMapProperties = { };
	String [] LodProperties = { "minLodPixels", "maxLodPixels", "minFadeExtent", "maxFadeExtent"};
	String [] StyleProperties = { };
	String [] DeleteProperties = { };
	String [] RegionProperties = { };
	String [] boundaryProperties = { };
	String [] UpdateProperties = { "targetHref"};
	String [] TimeStampProperties = { };
	String [] innerBoundaryIsProperties = { };
	String [] LinkProperties = { "href", "refreshMode", "refreshInterval", "viewRefreshMode", "viewRefreshTime", "viewBoundScale", "viewFormat", "httpQuery"};
	String [] DocumentProperties = { };
	String [] FeatureProperties = { "name", "visibility", "open", "address", "phoneNumber", "snippet", "description", "styleUrl"};
	String [] IconProperties = { "x", "y", "w", "h"};
	String [] ContainerProperties = { };
	String [] ModelProperties = { "altitudeMode"};
	String [] LinearRingProperties = { "extrude", "tessellate", "altitudeMode", "coordinates"};
	String [] GroundOverlayProperties = { "altitude", "altitudeMode"};
	String [] NetworkLinkProperties = { "refreshVisibility", "flyToView"};
	String [] ScreenOverlayProperties = { "rotation"};
	String [] PointProperties = { "extrude", "tessellate", "altitudeMode", "coordinates"};
	String [] IconStyleProperties = { "scale", "heading"};
	String [] FolderProperties = { };
	String [] LineStyleProperties = { "width"};
	String [] outerBoundaryIsProperties = { };
	String [] TimeSpanProperties = { };
	String [] ItemIconProperties = { "state", "href"};
	String [] MultiGeometryProperties = { };
	String [] vec2Properties = { };
	String [] StyleMapPairProperties = { "key", "styleUrl"};
	String [] LatLonAltBoxProperties = { "minAltitude", "maxAltitude", "altitudeMode"};
	String [] ObjectNodeProperties = { "id", "targetId"};
	String [] ScaleProperties = { "x", "y", "z"};
	String [] IconStyleIconProperties = { "href"};
	String [] NetworkLinkControlProperties = { "minRefreshPeriod", "cookie", "message", "linkName", "linkDescription", "linkSnippet"};
	String [] LatLonBoxProperties = { "north", "south", "east", "west", "rotation"};
	String [] TimePrimitiveProperties = { };
	String [] CreateProperties = { };
	String [] ColorStyleProperties = { "colorMode"};
	String [] OverlayProperties = { "drawOrder"};
	String [] LabelStyleProperties = { "scale"};
	String [] OrientationProperties = { "heading", "tilt", "roll"};
	String [] BalloonStyleProperties = { "text"};
	String [] ChangeProperties = { };
	String [] PolygonProperties = { "extrude", "tessellate", "altitudeMode"};
	String [] LookAtProperties = { "longitude", "latitude", "altitude", "range", "tilt", "heading", "altitudeMode"};
	String [] StyleSelectorProperties = { };
	String [] PolyStyleProperties = { "fill", "outline"};
	String [] ReplaceProperties = { };
	String [] GeometryProperties = { };
	String [] LineStringProperties = { "extrude", "tessellate", "altitudeMode", "coordinates"};
	String [] LocationProperties = { "longitude", "latitude", "altitude"};
	String [] MetadataProperties = { };
	String [] PlacemarkProperties = { };
	String [] ListStyleProperties = { "listItemType"};
	String path;
	path=rootPath;
	addObject(path, rootClass);
//	addProperties(path, KmlProperties);
//	digester.addSetNext(path, "addKml");
	path="*/StyleMap";
	addObject(path, StyleMap.class);
	addProperties(path, StyleMapProperties);
	addProperties(path, StyleSelectorProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addStyleMap");
	path="*/Lod";
	addObject(path, Lod.class);
	addProperties(path, LodProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addLod");
	path="*/Style";
	addObject(path, Style.class);
	addProperties(path, StyleProperties);
	addProperties(path, StyleSelectorProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addStyle");
	path="*/Delete";
	addObject(path, Delete.class);
	addProperties(path, DeleteProperties);
	digester.addSetNext(path, "addDelete");
	path="*/Region";
	addObject(path, Region.class);
	addProperties(path, RegionProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addRegion");
	path="*/boundary";
	addObject(path, boundary.class);
	addProperties(path, boundaryProperties);
	digester.addSetNext(path, "addBoundary");
	path="*/Update";
	addObject(path, Update.class);
	addProperties(path, UpdateProperties);
	digester.addSetNext(path, "addUpdate");
	path="*/TimeStamp";
	addObject(path, TimeStamp.class);
	addProperties(path, TimeStampProperties);
	addProperties(path, TimePrimitiveProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addTimeStamp");
	path="*/innerBoundaryIs";
	addObject(path, innerBoundaryIs.class);
	addProperties(path, innerBoundaryIsProperties);
	addProperties(path, boundaryProperties);
	digester.addSetNext(path, "addInnerBoundaryIs");
	path="*/Link";
	addObject(path, Link.class);
	addProperties(path, LinkProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addLink");
	path="*/Document";
	addObject(path, Document.class);
	addProperties(path, DocumentProperties);
	addProperties(path, ContainerProperties);
	addProperties(path, FeatureProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addDocument");
	path="*/Feature";
	addObject(path, Feature.class);
	addProperties(path, FeatureProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addFeature");
	path="*/Icon";
	addObject(path, Icon.class);
	addProperties(path, IconProperties);
	addProperties(path, LinkProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addIcon");
	path="*/Container";
	addObject(path, Container.class);
	addProperties(path, ContainerProperties);
	addProperties(path, FeatureProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addContainer");
	path="*/Model";
	addObject(path, Model.class);
	addProperties(path, ModelProperties);
	addProperties(path, GeometryProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addModel");
	path="*/LinearRing";
	addObject(path, LinearRing.class);
	addProperties(path, LinearRingProperties);
	addProperties(path, GeometryProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addLinearRing");
	path="*/GroundOverlay";
	addObject(path, GroundOverlay.class);
	addProperties(path, GroundOverlayProperties);
	addProperties(path, OverlayProperties);
	addProperties(path, FeatureProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addGroundOverlay");
	path="*/NetworkLink";
	addObject(path, NetworkLink.class);
	addProperties(path, NetworkLinkProperties);
	addProperties(path, FeatureProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addNetworkLink");
	path="*/ScreenOverlay";
	addObject(path, ScreenOverlay.class);
	addProperties(path, ScreenOverlayProperties);
	addProperties(path, OverlayProperties);
	addProperties(path, FeatureProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addScreenOverlay");
	path="*/Point";
	addObject(path, Point.class);
	addProperties(path, PointProperties);
	addProperties(path, GeometryProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addPoint");
	path="*/IconStyle";
	addObject(path, IconStyle.class);
	addProperties(path, IconStyleProperties);
	addProperties(path, ColorStyleProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addIconStyle");
	path="*/Folder";
	addObject(path, Folder.class);
	addProperties(path, FolderProperties);
	addProperties(path, ContainerProperties);
	addProperties(path, FeatureProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addFolder");
	path="*/LineStyle";
	addObject(path, LineStyle.class);
	addProperties(path, LineStyleProperties);
	addProperties(path, ColorStyleProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addLineStyle");
	path="*/outerBoundaryIs";
	addObject(path, outerBoundaryIs.class);
	addProperties(path, outerBoundaryIsProperties);
	addProperties(path, boundaryProperties);
	digester.addSetNext(path, "addOuterBoundaryIs");
	path="*/TimeSpan";
	addObject(path, TimeSpan.class);
	addProperties(path, TimeSpanProperties);
	addProperties(path, TimePrimitiveProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addTimeSpan");
	path="*/ItemIcon";
	addObject(path, ItemIcon.class);
	addProperties(path, ItemIconProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addItemIcon");
	path="*/MultiGeometry";
	addObject(path, MultiGeometry.class);
	addProperties(path, MultiGeometryProperties);
	addProperties(path, GeometryProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addMultiGeometry");
	path="*/vec2";
	addObject(path, vec2.class);
	addProperties(path, vec2Properties);
	digester.addSetNext(path, "addVec2");
	path="*/StyleMapPair";
	addObject(path, StyleMapPair.class);
	addProperties(path, StyleMapPairProperties);
	digester.addSetNext(path, "addStyleMapPair");
	path="*/LatLonAltBox";
	addObject(path, LatLonAltBox.class);
	addProperties(path, LatLonAltBoxProperties);
	addProperties(path, LatLonBoxProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addLatLonAltBox");
	path="*/ObjectNode";
	addObject(path, ObjectNode.class);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addObjectNode");
	path="*/Scale";
	addObject(path, Scale.class);
	addProperties(path, ScaleProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addScale");
	path="*/IconStyleIcon";
	addObject(path, IconStyleIcon.class);
	addProperties(path, IconStyleIconProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addIconStyleIcon");
	path="*/NetworkLinkControl";
	addObject(path, NetworkLinkControl.class);
	addProperties(path, NetworkLinkControlProperties);
	digester.addSetNext(path, "addNetworkLinkControl");
	path="*/LatLonBox";
	addObject(path, LatLonBox.class);
	addProperties(path, LatLonBoxProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addLatLonBox");
	path="*/TimePrimitive";
	addObject(path, TimePrimitive.class);
	addProperties(path, TimePrimitiveProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addTimePrimitive");
	path="*/Create";
	addObject(path, Create.class);
	addProperties(path, CreateProperties);
	digester.addSetNext(path, "addCreate");
	path="*/ColorStyle";
	addObject(path, ColorStyle.class);
	addProperties(path, ColorStyleProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addColorStyle");
	path="*/Overlay";
	addObject(path, Overlay.class);
	addProperties(path, OverlayProperties);
	addProperties(path, FeatureProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addOverlay");
	path="*/LabelStyle";
	addObject(path, LabelStyle.class);
	addProperties(path, LabelStyleProperties);
	addProperties(path, ColorStyleProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addLabelStyle");
	path="*/Orientation";
	addObject(path, Orientation.class);
	addProperties(path, OrientationProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addOrientation");
	path="*/BalloonStyle";
	addObject(path, BalloonStyle.class);
	addProperties(path, BalloonStyleProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addBalloonStyle");
	path="*/Change";
	addObject(path, Change.class);
	addProperties(path, ChangeProperties);
	digester.addSetNext(path, "addChange");
	path="*/Polygon";
	addObject(path, Polygon.class);
	addProperties(path, PolygonProperties);
	addProperties(path, GeometryProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addPolygon");
	path="*/LookAt";
	addObject(path, LookAt.class);
	addProperties(path, LookAtProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addLookAt");
	path="*/StyleSelector";
	addObject(path, StyleSelector.class);
	addProperties(path, StyleSelectorProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addStyleSelector");
	path="*/PolyStyle";
	addObject(path, PolyStyle.class);
	addProperties(path, PolyStyleProperties);
	addProperties(path, ColorStyleProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addPolyStyle");
	path="*/Replace";
	addObject(path, Replace.class);
	addProperties(path, ReplaceProperties);
	digester.addSetNext(path, "addReplace");
	path="*/Geometry";
	addObject(path, Geometry.class);
	addProperties(path, GeometryProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addGeometry");
	path="*/LineString";
	addObject(path, LineString.class);
	addProperties(path, LineStringProperties);
	addProperties(path, GeometryProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addLineString");
	path="*/Location";
	addObject(path, Location.class);
	addProperties(path, LocationProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addLocation");
	path="*/Metadata";
	addObject(path, Metadata.class);
	addProperties(path, MetadataProperties);
	digester.addSetNext(path, "addMetadata");
	path="*/Placemark";
	addObject(path, Placemark.class);
	addProperties(path, PlacemarkProperties);
	addProperties(path, FeatureProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addPlacemark");
	path="*/ListStyle";
	addObject(path, ListStyle.class);
	addProperties(path, ListStyleProperties);
	addProperties(path, ObjectNodeProperties);
	digester.addSetNext(path, "addListStyle");

	path="*/screenXY";
	addObject(path, vec2.class);
	digester.addSetNext(path, "addScreenXY");
	path="*/overlayXY";
	addObject(path, vec2.class);
	digester.addSetNext(path, "addOverlayXY");
	path="*/rotationXY";
	addObject(path, vec2.class);
	digester.addSetNext(path, "addRotationXY");
	path="*/size";
	addObject(path, vec2.class);
	digester.addSetNext(path, "addSize");
	path="*/hotSpot";
	addObject(path, vec2.class);
	digester.addSetNext(path, "addHotSpot");

	digester.addCallMethod("*/color", "setColor", 1, new Class[] {java.lang.String.class});
	digester.addCallParam("*/color", 0);
	digester.addCallMethod("*/when", "setWhen", 1, new Class[] {java.lang.String.class});
	digester.addCallParam("*/when", 0);
	digester.addCallMethod("*/begin", "setBegin", 1, new Class[] {java.lang.String.class});
	digester.addCallParam("*/begin", 0);
	digester.addCallMethod("*/end", "setEnd", 1, new Class[] {java.lang.String.class});
	digester.addCallParam("*/end", 0);
    }

    private void addObject(String path, Class aClass)
    {
	this.digester.addObjectCreate(path, aClass);
	this.digester.addSetProperties(path, "id", "id");
    }
        
    private void addProperties(String path, String [] props)
    {
	for (int i = 0; i < props.length; i++)
	{
	    this.digester.addBeanPropertySetter(path+"/"+props[i]);
	}
    }
    
    public Kml parse(Reader input) throws IOException, SAXException
    {
	return (Kml)this.digester.parse(input);
    }

    public Kml parse(File aFile) throws IOException, SAXException
    {
	return (Kml)this.digester.parse(aFile);
    }   
    
    public Node parseFragment(File aFile) throws IOException, SAXException
    {
	return (Node)this.digester.parse(aFile);
    }   
}
