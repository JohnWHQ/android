class test{

	location.start();
	listern.start();
	while(LocationFlag){
		if (GPSnums >= 4) {
			LocationGPS.start();
		}else if (LocationNet.isEnable) {
			LocationGPS.listerning();
			LocationNet.start();
		}else {
			INS.start();
			{x0,y0,ax,ay}
			vx = vx0 + F(ax, dt);
			vy = vy0 + F(ay, dt);
			dx = x0 + F(vx, dt);
			dy = y0 + F(yx, dt);
			x = x0 + dx;
			y = y0 + dy;
			int[] arr = check(x, y, xb, yb, arg...);
			//{INS.x,INS.y,INS.dx,INS.dy}
		}
	}

}