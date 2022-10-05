package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;
import shaders.StaticShader;

public class mainGameLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
		 float[] vertices = {
				    -0.5f, 0.5f, 0, //V0
				    -0.5f, -0.5f, 0,//V1
				    0.5f, -0.5f, 0, //V2
				    0.5f, 0.5f, 0, //V3
				  };
		 
		int[] indices = {
				0,1,3, // Top Left Triangle
				3,1,2  //Bottom Right Triangle
		};
		 
		 
		RawModel model = loader.loadToVAO(vertices, indices);
		 
		while(!Display.isCloseRequested()) {
			renderer.prepare();
			shader.start();
			renderer.render(model);
			shader.stop();
			//game logic
			//render
			
			DisplayManager.updateDisplay();
			
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
