import memojiImage from "@/assets/images/memoji-computer.png";
import Image from "next/image";
export const HeroSection = () => {
  return (
    <div>
      <div className="container">
        <Image src={memojiImage} alt="Person peeking behind the laptop" />
        <div>
          <div></div>
          <div>Available for new projects</div>
        </div>
        <h1>Building exception web apps using JAVA, Springboot</h1>
        <p>I'm specialise in Java Backend Developer , high-performing , have hands on experties in Jenkin, Oracle & Springboot</p>
      </div>
    </div>
  );
};
