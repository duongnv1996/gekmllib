package com.keithpower.gekmlib;
/**
 * AutoGenerated.
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class MultiGeometry extends Geometry
{
    protected List<Geometry> geometry = new ArrayList<Geometry>();


    public MultiGeometry()
    {
        super();
    }

    public MultiGeometry(Node parent)
    {
        super(parent);
    }

    public List<Geometry> getGeometrys()
    {
        return this.geometry;
    }

    public void removeGeometry(Geometry value)
    {
        if(value!=null)
        {
            markDeletedNode(value);
            this.geometry.remove(value);
        }
    }

    public void addGeometry(Geometry value)
    {
        if(value!=null)
        {
            value.setParent(this);
            markCreatedNode(value);
            this.geometry.add(value);
        }
    }

    public List<Model> getModels()
    {
        List<Model> list = new ArrayList<Model>();
        for (Geometry cur : getGeometrys())
        {
            if(cur instanceof Model)
            {
                 list.add((Model)cur);
            }
        }
        return list;
    }

    public void addModel(Model value)
    {
        if(value!=null)
        {
            value.setParent(this);
            this.geometry.add(value);
            markCreatedNode(value);
        }
        else
        {
        }
    }

    public List<LinearRing> getLinearRings()
    {
        List<LinearRing> list = new ArrayList<LinearRing>();
        for (Geometry cur : getGeometrys())
        {
            if(cur instanceof LinearRing)
            {
                 list.add((LinearRing)cur);
            }
        }
        return list;
    }

    public void addLinearRing(LinearRing value)
    {
        if(value!=null)
        {
            value.setParent(this);
            this.geometry.add(value);
            markCreatedNode(value);
        }
        else
        {
        }
    }

    public List<Point> getPoints()
    {
        List<Point> list = new ArrayList<Point>();
        for (Geometry cur : getGeometrys())
        {
            if(cur instanceof Point)
            {
                 list.add((Point)cur);
            }
        }
        return list;
    }

    public void addPoint(Point value)
    {
        if(value!=null)
        {
            value.setParent(this);
            this.geometry.add(value);
            markCreatedNode(value);
        }
        else
        {
        }
    }

    public List<MultiGeometry> getMultiGeometrys()
    {
        List<MultiGeometry> list = new ArrayList<MultiGeometry>();
        for (Geometry cur : getGeometrys())
        {
            if(cur instanceof MultiGeometry)
            {
                 list.add((MultiGeometry)cur);
            }
        }
        return list;
    }

    public void addMultiGeometry(MultiGeometry value)
    {
        if(value!=null)
        {
            value.setParent(this);
            this.geometry.add(value);
            markCreatedNode(value);
        }
        else
        {
        }
    }

    public List<Polygon> getPolygons()
    {
        List<Polygon> list = new ArrayList<Polygon>();
        for (Geometry cur : getGeometrys())
        {
            if(cur instanceof Polygon)
            {
                 list.add((Polygon)cur);
            }
        }
        return list;
    }

    public void addPolygon(Polygon value)
    {
        if(value!=null)
        {
            value.setParent(this);
            this.geometry.add(value);
            markCreatedNode(value);
        }
        else
        {
        }
    }

    public List<LineString> getLineStrings()
    {
        List<LineString> list = new ArrayList<LineString>();
        for (Geometry cur : getGeometrys())
        {
            if(cur instanceof LineString)
            {
                 list.add((LineString)cur);
            }
        }
        return list;
    }

    public void addLineString(LineString value)
    {
        if(value!=null)
        {
            value.setParent(this);
            this.geometry.add(value);
            markCreatedNode(value);
        }
        else
        {
        }
    }



    public String toKML()
    {
        return toKML(false);
    }
    public String toKML(boolean suppressEnclosingTags)
    {
        String kml="";
        if(!suppressEnclosingTags)
        {
        kml+="<MultiGeometry";
        if(this.id!=null)
        {
            kml+=" id=\""+this.getId()+"\"";
        }
        if(this.targetId!=null)
        {
            kml+=" targetId=\""+this.getTargetId()+"\"";
        }
        kml+=">\n";
        }
        kml+=super.toKML(true);
        for (Iterator<Geometry> iter = this.geometry.iterator(); iter.hasNext();)
        {
            Geometry cur = iter.next();
            kml+=cur.toKML();
        }
        if(!suppressEnclosingTags)
        {
            kml+="</MultiGeometry>\n";
        }
        return kml;
    }
    public String toUpdateKML()
    {
        return toUpdateKML(false);
    }
    public String toUpdateKML(boolean suppressEnclosingTags)
    {
        if(!isDirty())
        {
            return "";
        }
        String change = "";
        boolean isPrimDirty = isPrimitiveDirty(); // need to track it after object is setNotDirty
        if(isPrimDirty && !suppressEnclosingTags)
        {
        change+="<MultiGeometry";
        if(this.id!=null)
        {
            change+=" id=\""+this.getId()+"\"";
        }
        if(this.targetId!=null)
        {
            change+=" targetId=\""+this.getTargetId()+"\"";
        }
        change+=">\n";
        }
        change+=super.toUpdateKML(true);
        for (Iterator<Geometry> iter = this.geometry.iterator(); iter.hasNext();)
        {
            Geometry cur = iter.next();
            if(cur.isDirty())
            {
            change+=cur.toUpdateKML();
            }
        }
        if(isPrimDirty && !suppressEnclosingTags)
        {
        change+="</MultiGeometry>\n";
        }
        setNotDirty();
        return change;
    }
    public Object clone() throws CloneNotSupportedException
    {
        MultiGeometry result = (MultiGeometry)super.clone();
      if(result.geometry!=null)
      {
        result.geometry = new ArrayList<Geometry>();
        for (Iterator<Geometry> iter = this.geometry.iterator(); iter.hasNext();)
        {
            Geometry element = iter.next();
            Geometry elementClone = (Geometry)element.clone();
            elementClone.setParent(result);
        result.geometry.add(elementClone);
        }
      }
        return result;
    }
    public void setRecursiveNotDirty()
    {
        super.setRecursiveNotDirty();
        for (Iterator<Geometry> iter = this.geometry.iterator(); iter.hasNext();)
        {
            Geometry cur = iter.next();
            cur.setRecursiveNotDirty();
        }
    }
}
