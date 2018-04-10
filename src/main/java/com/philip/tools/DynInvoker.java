package com.philip.tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DynInvoker {
	public String Invoke(String className, String method, String... args) {
		String retVal = "";		
		try {
			Class<?> c = Class.forName(className);
			 Method[] allMethods = c.getDeclaredMethods();
			 for (Method m : allMethods) {
				if (!m.getName().equals(method)) {
				    continue;
				}
				System.out.println("find method ok!");
				//统一返回string类型
				if (!m.getReturnType().equals(String.class)) {
					//todo
				}
				Class<?>[] pType  = m.getParameterTypes();
				if (pType.length != args.length) {
					//todo
				}
				List<Object> params = new ArrayList<Object>();
				for (int i = 0; i < pType.length; i++) {
					Class<?> p = pType[i];
					if (p.equals(String.class)) {
						params.add(args[i]);
					} else if (p.equals(int.class)) {
						params.add(Integer.parseInt(args[i]));
					} else if (p.equals(long.class)) {
						params.add(Long.parseLong(args[i], 10));
					} else if (p.equals(double.class)) {
						params.add(Double.parseDouble(args[i]));
					} else if (p.equals(boolean.class)) {
						params.add(Boolean.parseBoolean(args[i]));
					} else {
						//todo
					}
				}
				System.out.println(m);
				System.out.println(params);
				
				//开始调用方法
				Object obj = c.newInstance();
				Object ret = m.invoke(obj, params.toArray());
				retVal = (String)ret;
				break;
			 }
		} catch (ClassNotFoundException x) {
		    x.printStackTrace();
		} catch (NumberFormatException x) {
			x.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retVal;
	}
}
