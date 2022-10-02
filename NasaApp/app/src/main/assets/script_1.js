window.addEventListener("load", init, false);

let Colors = {
  white: 0xffffff,
  black: 0x000000,
  red1: 0xaabbe3,
  red2: 0xaabbe3,
  red3: 0x4a6e8a,
  grey: 0xd9d1b9,
  darkGrey: 0x4d4b54,
  windowBlue: 0xaabbe3,
  windowDarkBlue: 0x4a6e8a,
  thrusterOrange: 0xfea036
};

let controls;

function init() {
  createScene();
  createLights();
  createRocket();
  // createSky();

  // document.addEventListener('mousemove', handleMouseMove, false);
  // controls = new THREE.OrbitControls(camera, renderer.domElement);
  loop();
}

let scene, HEIGHT, WIDTH;
let renderer, container;
let camera, aspectRatio, fieldOfView, nearPlane, farPlane;

const createScene = () => {
  HEIGHT = window.innerHeight;
  WIDTH = window.innerWidth;

  // Create the scene
  scene = new THREE.Scene();

  // Add a fog effect to the scene; same color as the
  // background color used in the style sheet
  scene.fog = new THREE.Fog(0xf7d9aa, 300, 950);

  // Create the camera
  aspectRatio = WIDTH / HEIGHT;
  fieldOfView = 40;
  nearPlane = 1;
  farPlane = 950;
  camera = new THREE.PerspectiveCamera(
    fieldOfView,
    aspectRatio,
    nearPlane,
    farPlane
  );

  camera.position.x = 0;
  camera.position.z = 400;
  camera.position.y = 50;

  // Create the renderer with transparent background and antialias
  renderer = new THREE.WebGLRenderer({
    alpha: true,
    antialias: true
  });
  renderer.setSize(WIDTH, HEIGHT);
  // enable shadows
  renderer.shadowMap.enabled = true;
  container = document.getElementById("world");
  container.appendChild(renderer.domElement);
};

let hemisphereLight, ambientLight, shadowLight, burnerLight;

const createLights = () => {
  // A hemisphere light is a gradient colored light;
  // the first parameter is the sky color, the second parameter is the ground color,
  // the third parameter is the intensity of the light
  hemisphereLight = new THREE.HemisphereLight(0xaaaaaa, 0x000000, 0.9);

  // an ambient light modifies the global color of a scene and makes the shadows softer
  ambientLight = new THREE.AmbientLight(0xccb8b4, 0.6);
  scene.add(ambientLight);

  // A directional light shines from a specific direction.
  // It acts like the sun, that means that all the rays produced are parallel.
  shadowLight = new THREE.DirectionalLight(0xffffff, 0.8);

  // Set the direction of the light
  shadowLight.position.set(150, 150, 0);
  shadowLight.castShadow = true;

  // define the visible area of the projected shadow
  shadowLight.shadow.camera.left = -800;
  shadowLight.shadow.camera.right = 800;
  shadowLight.shadow.camera.top = 800;
  shadowLight.shadow.camera.bottom = -800;
  shadowLight.shadow.camera.near = 1;
  shadowLight.shadow.camera.far = 1200;

  // res of shadow
  shadowLight.shadow.mapSize.width = 2048;
  shadowLight.shadow.mapSize.height = 2048;

  burnerLight = new THREE.DirectionalLight(Colors.thrusterOrange, 0.75);

  burnerLight.position.set(0, -5, 0);
  burnerLight.castShadow = true;

  burnerLight.shadow.camera.left = -100;
  burnerLight.shadow.camera.right = 100;
  shadowLight.shadow.camera.top = 100;
  burnerLight.shadow.camera.bottom = -100;
  burnerLight.shadow.camera.near = 1;
  burnerLight.shadow.camera.far = 1000;

  burnerLight.shadow.mapSize.width = 2048;
  burnerLight.shadow.mapSize.height = 2048;

  scene.add(hemisphereLight);
  scene.add(shadowLight);
  scene.add(burnerLight);
  scene.add(ambientLight);
};

class Rocket {
  constructor() {
    this.mesh = new THREE.Object3D();

    // custom shapes
    let geoFinShape = new THREE.Shape();
    let x = 0,
      y = 0;

    geoFinShape.moveTo(x, y);
    geoFinShape.lineTo(x, y + 50);
    geoFinShape.lineTo(x + 35, y + 10);
    geoFinShape.lineTo(x + 35, y - 10);
    geoFinShape.lineTo(x, y);

    let finExtrudeSettings = {
      amount: 8,
      bevelEnabled: true,
      bevelSegments: 2,
      steps: 2,
      bevelSize: 1,
      bevelThickness: 1
    };

    let geoWindowShape = new THREE.Shape();
    geoWindowShape.moveTo(x - 18, y + 45);
    geoWindowShape.lineTo(x + 18, y + 45);
    geoWindowShape.lineTo(x + 18, y - 45);
    geoWindowShape.lineTo(x - 18, y - 45);
    geoWindowShape.lineTo(x - 18, y + 45);

    // geometry
    let geoCone = new THREE.ConeGeometry(50, 70, 8);
    let geoUpper = new THREE.CylinderGeometry(50, 75, 80, 8);
    let geoMiddle = new THREE.CylinderGeometry(75, 85, 80, 8);
    let geoColumn = new THREE.CylinderGeometry(85, 85, 200, 8);
    let geoWindowFrameOuter = new THREE.CylinderGeometry(55, 55, 40, 8);
    let geoWindowFrameInner = new THREE.CylinderGeometry(40, 40, 40, 16);
    let geoWindow = new THREE.CylinderGeometry(50, 50, 40, 8);
    let geoWindowReflection = new THREE.ShapeGeometry(geoWindowShape);
    let geoFin = new THREE.ExtrudeGeometry(geoFinShape, finExtrudeSettings);
    let geoThruster = new THREE.CylinderGeometry(55, 55, 40, 8);
    let geoConnector = new THREE.CylinderGeometry(55, 35, 10, 8);

    // materials
    let matRoof1 = new THREE.MeshPhongMaterial({
      color: Colors.red1,
      flatShading: true
    });
    let matRoof2 = new THREE.MeshPhongMaterial({
      color: Colors.red2,
      flatShading: true
    });
    let matRoof3 = new THREE.MeshPhongMaterial({
      color: Colors.red3,
      flatShading: true
    });
    let matBody = new THREE.MeshPhongMaterial({
      color: Colors.grey,
      flatShading: true
    });
    let matWindowFrame = new THREE.MeshPhongMaterial({
      color: Colors.darkGrey,
      side: THREE.DoubleSide,
      flatShading: true
    });
    let matWindow = new THREE.MeshPhongMaterial({
      color: Colors.windowDarkBlue
    });
    let matWindowReflection = new THREE.MeshPhongMaterial({
      color: Colors.windowBlue
    });
    let matThruster = new THREE.MeshPhongMaterial({
      color: Colors.thrusterOrange,
      flatShading: true
    });

    let m = new THREE.Mesh(geoCone, matRoof1);
    m.position.y = 70;
    m.castShadow = true;
    m.receiveShadow = true;

    let m2 = new THREE.Mesh(geoUpper, matRoof2);
    m2.castShadow = true;
    m2.receiveShadow = true;

    let m3 = new THREE.Mesh(geoMiddle, matRoof3);
    m3.position.y = -70;
    m3.castShadow = true;
    m3.receiveShadow = true;

    this.roof = new THREE.Object3D();
    this.roof.add(m, m2, m3);

    let mColumn = new THREE.Mesh(geoColumn, matBody);
    mColumn.position.y = -210;
    mColumn.position.x = 0;
    mColumn.position.z = 0;
    mColumn.castShadow = true;
    mColumn.receiveShadow = true;

    let zPlacement = 85;
    let yPlacement = -310;
    let xPlacement = 8;
    let yRotation = 1.6;
    let scale = 1.8;
    let finWidth = 15;
    let mFinLeft = new THREE.Mesh(geoFin, matRoof3);
    mFinLeft.position.y = yPlacement;
    mFinLeft.position.z = -zPlacement;
    mFinLeft.rotation.y = yRotation - 0.08;
    mFinLeft.scale.set(scale, scale, scale);
    mFinLeft.castShadow = true;
    mFinLeft.receiveShadow = true;
    let mFinRight = new THREE.Mesh(geoFin, matRoof3);
    mFinRight.position.y = yPlacement;
    mFinRight.position.z = zPlacement;
    mFinRight.rotation.y = -yRotation;
    mFinRight.scale.set(scale, scale, scale);
    mFinRight.castShadow = true;
    mFinRight.receiveShadow = true;

    let mfins = new THREE.Object3D();
    mfins.rotation.y += 0.05;
    mfins.add(mFinLeft, mFinRight);
    this.body = new THREE.Object3D();
    this.body.add(mColumn, mfins);

    let innerMesh = new THREE.Mesh(geoWindowFrameInner);
    innerMesh.rotation.y = 0.2;
    let outerCylinder = new ThreeBSP(geoWindowFrameOuter);
    let innerCylinder = new ThreeBSP(innerMesh);

    let hollowed = outerCylinder.union(innerCylinder);
    let m5 = hollowed.toMesh(matWindowFrame);
    m5.position.y = -200;
    m5.position.x = -77;
    m5.rotation.z = 1.59;
    m5.castShadow = true;
    m5.receiveShadow = true;

    let m6 = new THREE.Mesh(geoWindow, matWindow);
    m6.position.y = -200;
    m6.position.x = -67;
    m6.rotation.z = 1.59;
    m6.castShadow = true;
    m6.receiveShadow = true;

    let mWindowReflection = new THREE.Mesh(
      geoWindowReflection,
      matWindowReflection
    );
    mWindowReflection.position.x = -90;
    mWindowReflection.position.y = -200;
    mWindowReflection.rotation.y = -1.5;
    mWindowReflection.rotation.x = 0.82;
    mWindowReflection.receiveShadow = true;

    this.window = new THREE.Object3D();
    this.window.add(m5, m6, mWindowReflection);

    let mThruster = new THREE.Mesh(geoThruster, matWindowFrame);
    mThruster.position.y = -305;
    mThruster.receiveShadow = true;
    mThruster.castShadow = true;

    let mConnector = new THREE.Mesh(geoConnector, matThruster);
    mConnector.position.y = -330;
    mConnector.receiveShadow = true;
    mConnector.castShadow = true;

    let mBurner = new THREE.Mesh(geoThruster, matWindowFrame);
    mBurner.position.y = -340;
    mBurner.scale.set(0.7, 0.55, 0.7);
    mBurner.receiveShadow = true;
    mBurner.castShadow = true;

    this.base = new THREE.Object3D();
    this.base.add(mThruster, mConnector, mBurner);

    this.mesh.add(this.roof);
    this.mesh.add(this.body);
    this.mesh.add(this.window);
    this.mesh.add(this.base);
  }
}

class Base {
  constructor() {
    this.mesh = new THREE.Object3D();
    let geo = new THREE.CylinderGeometry(70, 80, 50, 8);
    let mat = new THREE.MeshPhongMaterial({
      color: Colors.darkGrey
    });
    let m = new THREE.Mesh(geo, mat);
    m.castShadow = true;
    m.receiveShadow = true;
    this.mesh.add(m);
  }
}

let rocket;

const createRocket = () => {
  rocket = new Rocket();
  rocket.mesh.scale.set(0.2, 0.2, 0.2);
  rocket.mesh.position.y = -40;
  rocket.mesh.rotation.y = 1.5;
  scene.add(rocket.mesh);

  // let base = new Base();
  // base.mesh.position.y = -190;
  // base.mesh.scale.set(3.3, 0.8, 3.3);
  // scene.add(base.mesh);
};

let particleArray = [],
  slowMoFactor = 1;

const loop = () => {
  // render the scene
  renderer.render(scene, camera);

  if (rocket.mesh.position.y < 130) {
    rocket.mesh.position.y += 1;
    rocket.mesh.position.x = Math.random() * Math.PI * 0.5;
    rocket.mesh.rotation.x = Math.random() * Math.sin(1) * 0.04;
    rocket.mesh.rotation.z = Math.random() * Math.sin(1) * 0.04;
    rocket.mesh.position.z = Math.random() * Math.PI * 0.5;
  } else {
    rocket.mesh.rotation.y += Math.sin(1) * 0.02;
  }

  if (rocket.mesh.position.y > 350) {
    rocket.mesh.position.y = -300;
  }

  setTimeout(() => {
    createSmoke(rocket);
  }, 1000);
  createFlyingParticles();

  // controls.update();
  requestAnimationFrame(loop);
};

const getParticle = () => {
  let p;
  if (particleArray.length > 0) {
    p = particleArray.pop();
  } else {
    p = new Particle();
  }
  return p;
};

const createSmoke = (rocket) => {
  let p = getParticle();
  dropParticle(p, rocket);
};

const createFlyingParticles = () => {
  let p = getParticle();
  flyParticle(p);
};

class Particle {
  constructor() {
    this.isFlying = false;

    var scale = 20 + Math.random() * 20;
    var nLines = 3 + Math.floor(Math.random() * 5);
    var nRows = 3 + Math.floor(Math.random() * 5);
    this.geometry = new THREE.SphereGeometry(scale, nLines, nRows);

    this.material = new THREE.MeshLambertMaterial({
      color: 0xe3e3e3,
      shading: THREE.FlatShading,
      transparent: true
    });

    this.mesh = new THREE.Mesh(this.geometry, this.material);
    recycleParticle(this);
  }
}

function recycleParticle(p) {
  p.mesh.position.x = 0;
  p.mesh.position.y = 0;
  p.mesh.position.z = 0;
  p.mesh.rotation.x = Math.random() * Math.PI * 2;
  p.mesh.rotation.y = Math.random() * Math.PI * 2;
  p.mesh.rotation.z = Math.random() * Math.PI * 2;
  p.mesh.scale.set(0.1, 0.1, 0.1);
  p.mesh.material.opacity = 0;
  p.color = 0xe3e3e3;
  p.mesh.material.color.set(p.color);
  p.material.needUpdate = true;
  scene.add(p.mesh);
  particleArray.push(p);
}
function flyParticle(p) {
  var targetPosX, targetPosY, targetSpeed, targetColor;
  p.mesh.material.opacity = 1;
  p.mesh.position.x = -1000 + Math.random() * 2000;
  p.mesh.position.y = 100 + Math.random() * 2000;
  p.mesh.position.z = -1000 + Math.random() * 1500;

  var s = Math.random() * 0.2;
  p.mesh.scale.set(s, s, s);

  targetPosX = 0;
  targetPosY = -p.mesh.position.y - 2500;
  targetSpeed = 1 + Math.random() * 2;
  targetColor = 0xe3e3e3;

  TweenMax.to(p.mesh.position, targetSpeed * slowMoFactor, {
    x: targetPosX,
    y: targetPosY,
    ease: Linear.easeNone,
    onComplete: recycleParticle,
    onCompleteParams: [p]
  });
}

let cloudTargetPosX,
  cloudTargetPosY,
  cloudTargetSpeed,
  cloudTargetColor,
  cloudSlowMoFactor = 0.65;
const dropParticle = (p, rocket) => {
  p.mesh.material.opacity = 1;
  p.mesh.position.x = 0;
  p.mesh.position.y = rocket.mesh.position.y - 80;
  p.mesh.position.z = 0;
  var s = Math.random(0.2) + 0.35;
  p.mesh.scale.set(0.4 * s, 0.4 * s, 0.4 * s);
  cloudTargetPosX = 0;
  cloudTargetPosY = rocket.mesh.position.y - 500;
  cloudTargetSpeed = 0.8 + Math.random() * 0.6;
  cloudTargetColor = 0xa3a3a3;

  TweenMax.to(p.mesh.position, 1.3 * cloudTargetSpeed * cloudSlowMoFactor, {
    x: cloudTargetPosX,
    y: cloudTargetPosY,
    ease: Linear.easeNone,
    onComplete: recycleParticle,
    onCompleteParams: [p]
  });

  TweenMax.to(p.mesh.scale, cloudTargetSpeed * cloudSlowMoFactor, {
    x: s * 1.8,
    y: s * 1.8,
    z: s * 1.8,
    ease: Linear.ease
  });
};

// handle window resize
window.onresize = () => {
  // update height and width of the renderer and the camera
  HEIGHT = window.innerHeight;
  WIDTH = window.innerWidth;
  renderer.setSize(WIDTH, HEIGHT);
  camera.aspect = WIDTH / HEIGHT;
  camera.updateProjectionMatrix();
};

// inspiration/credits:

// https://codepen.io/murdoc/pen/aOPaqZ?editors=0010#0
// https://codepen.io/carrot-e/pen/WGkJBZ?editors=0010
// https://codepen.io/Yakudoo/pen/eNmjEv?editors=0010